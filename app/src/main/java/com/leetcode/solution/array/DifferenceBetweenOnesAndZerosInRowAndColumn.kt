package com.leetcode.solution.array

class Solution2482 {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        // 计算行列和
        val rows = grid.map { it.sum() }.toIntArray()
        val cols = IntArray(n) { j -> grid.sumOf { it[j] } }

        val res = Array(m) { IntArray(n) {0} }
        for (i in 0 until m) {
            for (j in 0 until n) {
                res[i][j] = 2 * (rows[i] + cols[j]) - m - n
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution2482()
    check(solution.onesMinusZeros(arrayOf(intArrayOf(0,1,1), intArrayOf(1,0,1), intArrayOf(0,0,1))).contentDeepEquals(arrayOf(intArrayOf(2)))) { "test1 wrong result" }
    check(solution.onesMinusZeros(arrayOf(intArrayOf(1,1,1), intArrayOf(1,1,1))).contentDeepEquals(arrayOf(intArrayOf(5,5,5),intArrayOf(5,5,5)))) { "test2 wrong result" }
}
