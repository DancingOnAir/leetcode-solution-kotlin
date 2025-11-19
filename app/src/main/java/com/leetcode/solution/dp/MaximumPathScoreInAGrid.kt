package com.leetcode.solution.dp

import kotlin.math.max

private data class State(val i: Int, val j: Int, val k: Int)

class Solution3742 {
    fun maxPathScore(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = MutableList(m + 1) { MutableList(n + 1) { MutableList(k + 2) { Int.MIN_VALUE }}}
        for (i in 1..k+1) {
            // 这里是为了让dp[1][1]为0，初始化dp[1][0][i] = 0也行的
            dp[0][1][i] = 0
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                val x = grid[i][j]
                for (k in 0..k) {
                    val newK = if (x > 0) k - 1 else k
                    dp[i + 1][j + 1][k + 1] = max(dp[i + 1][j][newK + 1], dp[i][j + 1][newK + 1]) + x
                }
            }
        }

        val res = dp[m][n][k + 1]
        return if (res < 0) -1 else res
    }

    // dfs
    fun maxPathScore1(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val memo = mutableMapOf<State, Int>()

        fun dfs(i: Int, j: Int, k: Int): Int {
            if (i < 0 || j < 0 || k < 0)
                return Int.MIN_VALUE
            if (i == 0 && j == 0)
                return 0

            val cur = State(i, j, k)
            memo[cur]?.let { return it }

            val x = grid[i][j]
            val res = max(dfs(i - 1, j, k - (if (x > 0) 1 else 0)) + x,dfs(i, j - 1, k - (if (x > 0) 1 else 0)) + x)
            memo[cur] = res
            return res
        }

        val ans = dfs(m - 1, n - 1, k)
        return if (ans < 0) -1 else ans
    }
}

fun main() {
    val solution = Solution3742()
    check(solution.maxPathScore(arrayOf(intArrayOf(0,1), intArrayOf(2,0)), 1) == 2) {"test1"}
    check(solution.maxPathScore(arrayOf(intArrayOf(0,1), intArrayOf(1,2)), 1) == -1) {"test2"}
}
