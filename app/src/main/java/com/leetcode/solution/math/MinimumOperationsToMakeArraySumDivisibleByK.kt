package com.leetcode.solution.math

class Solution3512 {
    fun minOperations(nums: IntArray, k: Int) = nums.sum() % k

    fun minOperations1(nums: IntArray, k: Int): Int {
        return nums.sum() % k
    }
}

fun main() {
    val solution = Solution3512()
    check(solution.minOperations(intArrayOf(3,9,7), k = 5) == 4) {"wrong result"}
    check(solution.minOperations(intArrayOf(4,1,3), k = 4) == 0) {"wrong result"}
    check(solution.minOperations(intArrayOf(3,2), k = 6) == 5) {"wrong result"}
}
