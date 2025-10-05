package com.leetcode.solution.array

class Solution3674 {
    fun minOperations(nums: IntArray): Int {
        return if (nums.toSet().size <= 1) return 0 else 1
    }
}

fun main() {
    val solution = Solution3674()
    check(solution.minOperations(intArrayOf(1,2)) == 1) { "test1 wrong result" }
    check(solution.minOperations(intArrayOf(5,5,5)) == 0) { "test2 wrong result" }
}