package com.leetcode.solution.array

import kotlin.math.max

class Solution2500 {
    fun deleteGreatestValue(grid: Array<IntArray>): Int {
        grid.forEachIndexed { i, x -> grid[i] = x.sortedArray() }
        var res = 0
        for (c in grid[0].indices) {
            var mx = Int.MIN_VALUE
            for (r in grid.indices) {
                mx = max(mx, grid[r][c])
            }
            res += mx
        }
        return res
    }
}

fun main() {
    val solution = Solution2500()
    check(solution.deleteGreatestValue(arrayOf(intArrayOf(1,2,4), intArrayOf(3,3,1))) == 8 ){ "test1 wrong result" }
    check(solution.deleteGreatestValue(arrayOf(intArrayOf(10))) == 10) { "test2 wrong result" }
}