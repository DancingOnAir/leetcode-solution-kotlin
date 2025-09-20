package com.leetcode.solution.dfs

class Solution3619 {
    fun countIslands(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size

        fun dfs(i: Int, j: Int): Long {
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0)
                return 0
            val res = grid[i][j].toLong()
            grid[i][j] = 0
            return res + dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j - 1) + dfs(i, j + 1)
        }

        var res = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] != 0) {
                    val cur = dfs(i, j)
                    if (cur % k == 0L) {
                        res++
                    }
                }
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution3619()
    check(solution.countIslands(arrayOf(intArrayOf(0,2,1,0,0), intArrayOf(0,5,0,0,5), intArrayOf(0,0,1,0,0), intArrayOf(0,1,4,7,0), intArrayOf(0,2,0,0,8)), 5) == 2) { "test1 wrong result" }
    check(solution.countIslands(arrayOf(intArrayOf(3,0,3,0), intArrayOf(0,3,0,3), intArrayOf(3,0,3,0)), 3) == 6) { "test2 wrong result" }
}