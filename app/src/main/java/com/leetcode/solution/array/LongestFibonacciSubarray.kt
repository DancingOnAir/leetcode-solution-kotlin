package com.leetcode.solution.array

import kotlin.math.max

class Solution3708 {
    fun longestSubarray(nums: IntArray): Int {
        var res = 2
        var cur = 2
        for (i in 2..nums.lastIndex) {
            if (nums[i] == nums[i - 1] + nums[i - 2]) {
                cur++
                res = max(res, cur)
            } else {
                cur = 2
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution3708()
    check(solution.longestSubarray(intArrayOf(1,1,1,1,2,3,5,1)) == 5) {"test1 wrong result"}
    check(solution.longestSubarray(intArrayOf(5,2,7,9,16)) == 5) {"test2 wrong result"}
    check(solution.longestSubarray(intArrayOf(1000000000,1000000000,1000000000)) == 2) {"test3 wrong result"}
}
