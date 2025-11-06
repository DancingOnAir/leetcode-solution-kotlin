package com.leetcode.solution.bitManipulation

class Solution3702 {
    fun longestSubsequence(nums: IntArray): Int {
        var xorSum = 0
        var orSum = 0
        for (x in nums) {
            xorSum = xorSum xor x
            orSum = orSum or x
        }

        if (xorSum != 0)
            return nums.size
        if (orSum != 0)
            return nums.size - 1
        return 0
    }

    fun longestSubsequence1(nums: IntArray): Int {
        val tot = nums.reduce{acc, i -> acc xor i}
        if (tot != 0)
            return nums.size
        if (nums.any { it > 0 })
            return nums.size - 1
        return 0
    }
}

fun main() {
    val solution = Solution3702()
    check(solution.longestSubsequence(intArrayOf(1,2,3)) == 2) {"test1 wrong result"}
    check(solution.longestSubsequence(intArrayOf(2,3,4)) == 3) {"test2 wrong result"}
}
