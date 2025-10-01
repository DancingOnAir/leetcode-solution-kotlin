package com.leetcode.solution.array

class Solution3689 {
    fun maxTotalValue(nums: IntArray, k: Int): Long {
        return (nums.max() - nums.min()).toLong() * k
    }
}

fun main() {
    val solution = Solution3689()
    check(solution.maxTotalValue(intArrayOf(1,3,2),2) == 4L) {"testing1 wrong result"}
    check(solution.maxTotalValue(intArrayOf(4,2,5,1), 3) == 12L) {"testing2 wrong result"}
}
