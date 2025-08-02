package com.leetcode.solution.math

import kotlin.math.max

class Solution0883 {
    fun projectionArea(grid: Array<IntArray>): Int {
        var res = 0
        val n = grid.size
        for (i in 0..n - 1) {
            var x = 0
            var y = 0
            for (j in 0..n - 1) {
                x = max(x, grid[i][j])
                y = max(y, grid[j][i])
                if (grid[i][j] != 0)
                    res++
            }
            res += x + y
        }
        return res
    }
}

fun main() {
    val solution = Solution0883()
    check(solution.projectionArea(arrayOf(intArrayOf(1,2), intArrayOf(3,4))) == 17) {"test1 wrong result"}
    check(solution.projectionArea(arrayOf(intArrayOf(2))) == 5) {"test2 wrong result"}
    check(solution.projectionArea(arrayOf(intArrayOf(1,0), intArrayOf(0,2))) == 8) {"test3 wrong result"}
}