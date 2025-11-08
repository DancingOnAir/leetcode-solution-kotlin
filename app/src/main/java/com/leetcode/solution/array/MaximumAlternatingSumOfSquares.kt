package com.leetcode.solution.array

import kotlin.math.abs

class Solution3727 {
    fun maxAlternatingSum(nums: IntArray): Long {
        val n = nums.size
        var res = 0L
        for ((i, x) in nums.sortedBy { abs(it) }.withIndex()) {
            if (i < n / 2) {
                res += -(x * x)
            }
            else {
                res += x * x
            }
        }

        return res
    }
}

fun main() {
    val solution = Solution3727()
    check(solution.maxAlternatingSum(intArrayOf(1,2,3)) == 12L) {"test1 wrong result"}
    check(solution.maxAlternatingSum(intArrayOf(1,-1,2,-2,3,-3)) == 16L) {"test2 wrong result"}
}
