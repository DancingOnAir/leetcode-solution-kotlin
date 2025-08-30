package com.leetcode.solution.array

import kotlin.math.max

class Solution2639 {
    fun findColumnWidth(grid: Array<IntArray>): IntArray {
        val res = IntArray(grid[0].size)
        for (j in 0 until grid[0].size) {
            for (i in 0 until grid.size) {
                res[j] = max(res[j], grid[i][j].toString().length)
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution2639()
    check(solution.findColumnWidth(arrayOf(intArrayOf(1),intArrayOf(22),intArrayOf(333)))
        .contentEquals(intArrayOf(3))) { "testing1 wrong result" }
    check(solution.findColumnWidth(arrayOf(intArrayOf(-15,1,3),intArrayOf(15,7,12),intArrayOf(5,6,-2)))
        .contentEquals(intArrayOf(3,1,2))) { "testing2 wrong result" }
}
