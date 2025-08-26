package com.leetcode.solution.array

class Solution1913 {
    fun maxProductDifference(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size - 1] * nums[nums.size - 2] - nums[0] * nums[1]
    }
}

fun main() {
    val solution = Solution1913()
    check(
        solution.maxProductDifference(
            intArrayOf(
                5,
                6,
                2,
                7,
                4
            )
        ) == 34
    ) { "testing1 wrong result" }
    check(
        solution.maxProductDifference(
            intArrayOf(
                4,
                2,
                5,
                9,
                7,
                4,
                8
            )
        ) == 64
    ) { "testing2 wrong result" }
}