package com.leetcode.solution.array

class Solution3643 {
    fun reverseSubmatrix(grid: Array<IntArray>, x: Int, y: Int, k: Int): Array<IntArray> {
        for(i in 0 until k/2) {
            for (j in y until y+k) {
                val temp = grid[x + k - 1 - i][j]
                grid[x + k - 1 - i][j] = grid[x + i][j]
                grid[x + i][j] = temp
            }
        }
        return grid
    }
}

fun main() {
    val solution = Solution3643()
    check(solution.reverseSubmatrix(arrayOf(intArrayOf(1,2,3,4),intArrayOf(5,6,7,8),intArrayOf(9,10,11,12),intArrayOf(13,14,15,16)),1,0,3).contentEquals(arrayOf(intArrayOf(1,2,3,4),intArrayOf(13,14,15,8),intArrayOf(9,10,11,12),intArrayOf(5,6,7,16)))) {"test1 wrong result"}
    check(solution.reverseSubmatrix(arrayOf(intArrayOf(3,4,2,3),intArrayOf(2,3,4,2)),0,2,2).contentEquals(arrayOf(intArrayOf(3,4,4,2),intArrayOf(2,3,2,3)))) {"test2 wrong result"}
}
