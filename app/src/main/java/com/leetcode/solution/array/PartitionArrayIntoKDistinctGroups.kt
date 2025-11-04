package com.leetcode.solution.array

class Solution3659 {
    fun partitionArray(nums: IntArray, k: Int): Boolean {
        if (nums.size % k != 0)
            return false
        val cnt = nums.toList().groupingBy { it }.eachCount()
        if (cnt.values.max() > nums.size / k)
            return false
        return true
    }
}

fun main() {
    val solution = Solution3659()
    check(solution.partitionArray(intArrayOf(1,2,3,4), 2)) {"test1 wrong result"}
    check(solution.partitionArray(intArrayOf(3,5,2,2), 2)) {"test2 wrong result"}
    check(!solution.partitionArray(intArrayOf(1,5,2,3), 3)) {"test3 wrong result"}
}
