package com.leetcode.solution.array

import kotlin.math.abs
import kotlin.math.min

class Solution3567 {
    fun minAbsDiff(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        val res = Array(m - k + 1) { IntArray(n - k + 1) {0} }
        for (i in 0 until m - k + 1) {
            for (j in 0 until n - k + 1) {
                val cur = mutableListOf<Int>()
                for (r in i until i + k) {
                    for (c in j until j + k) {
                        cur.add(grid[r][c])
                    }
                }
                cur.sort()

                var diff = Int.MAX_VALUE
                for (k in 0 until cur.size - 1) {
                    if (cur[k + 1] > cur[k])
                        diff = min(diff, cur[k + 1] - cur[k])
                }
                if (diff < Int.MAX_VALUE)
                    res[i][j] = diff
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution3567()
    check(solution.minAbsDiff(arrayOf(intArrayOf(1,8), intArrayOf(3,-2)),2)
        .contentDeepEquals(arrayOf(intArrayOf(2)))) { "test1 wrong result" }
    check(solution.minAbsDiff(arrayOf(intArrayOf(3,-1)),1).contentDeepEquals(arrayOf(intArrayOf(0,0)))) { "test2 wrong result" }
    check(solution.minAbsDiff(arrayOf(intArrayOf(1,-2,3), intArrayOf(2,3,5)),2).contentDeepEquals(arrayOf(intArrayOf(1,2)))) { "test3 wrong result" }
}