package com.leetcode.solution.slidingWindow

import kotlin.math.max

class Solution3652 {
    fun maxProfit(prices: IntArray, strategy: IntArray, k: Int): Long {
        var tot = 0L
        var mx = 0L
        var s = 0L
        for ((i, p) in prices.withIndex()) {
            val st = strategy[i]
            tot += p * st
            s += p * (1 - st)
            if (i < k - 1) {
                if (i >= k / 2 - 1) {
                    s -= prices[i - k / 2 + 1]
                }
                continue
            }

            mx = max(mx, s)

            s -= prices[i - k / 2 + 1] - prices[i - k + 1] * strategy[i - k + 1]
        }
        return tot + mx
    }
}

fun main() {
    val solution = Solution3652()
    check(solution.maxProfit(intArrayOf(4,2,8), intArrayOf(-1,0,1), 2) == 10L) {"test1"}
    check(solution.maxProfit(intArrayOf(5,4,3), intArrayOf(1,1,0), 2) ==9L) {"test2"}
}
