package com.leetcode.solution.dp

import kotlin.math.min

class Solution3693 {
    fun climbStairs(n: Int, costs: IntArray): Int {
        // 初始化IntArray
        val dp = IntArray(n + 1) {Int.MAX_VALUE}
        dp[n] = 0
        for (i in n - 1 downTo 0) {
            dp[i] = costs[i] + 1 + dp[i + 1]
            if (i + 2 <= n)
                dp[i] = min(dp[i], costs[i + 1] + 4 + dp[i + 2])
            if (i + 3 <= n)
                dp[i] = min(dp[i], costs[i + 2] + 9 + dp[i + 3])
        }
        return dp[0]
    }

    fun climbStairs1(n: Int, costs: IntArray): Int {
        val m = mutableMapOf<Int, Int>()

        fun dfs(i: Int): Int {
            if (i == n)
                return 0
            m[i]?.let { return it }
            var res = costs[i] + 1 + dfs(i + 1)
            if (i + 2 <= n)
                res = min(res, costs[i + 1] + 4 + dfs(i + 2))
            if (i + 3 <= n)
                res = min(res, costs[i + 2] + 9 + dfs(i + 3))
            m[i] = res
            return res
        }

        return dfs(0)
    }
}

fun main() {
    val solution = Solution3693()
    check(solution.climbStairs(4, intArrayOf(1,2,3,4)) == 13) {"test1 wrong result"}
    check(solution.climbStairs(4, intArrayOf(5,1,6,2)) == 11) {"test2 wrong result"}
    check(solution.climbStairs(3, intArrayOf(9,8,3)) == 12) {"test3 wrong result"}
}
