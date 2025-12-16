package com.leetcode.solution.dp

import kotlin.math.max

class Solution3640 {
    fun maxSumTrionic(nums: IntArray): Long {
        val n = nums.size
        val dp = List(4) { LongArray(n) { (-1e18).toLong() } }
        var res = Long.MIN_VALUE
        for (i in 0 until n) {
            val x = nums[i].toLong()
            dp[0][i] = x
            if (i != 0) {
                if (nums[i] > nums[i - 1])
                    dp[1][i] = max(dp[0][i - 1] + x, dp[1][i - 1] + x)
                if (nums[i] < nums[i - 1])
                    dp[2][i] = max(dp[1][i - 1] + x, dp[2][i - 1] + x)
                if (nums[i] > nums[i - 1])
                    dp[3][i] = max(dp[2][i - 1] + x, dp[3][i - 1] + x)
            }
            res = max(res, dp[3][i])
        }
        return res
    }
}

fun main() {
    val solution = Solution3640()
    check(solution.maxSumTrionic(intArrayOf(0,-2,-1,-3,0,2,-1)) == -4L) {"test1"}
    check(solution.maxSumTrionic(intArrayOf(1,4,2,7)) == 14L) {"test2"}
}
