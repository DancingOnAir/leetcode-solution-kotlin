package com.leetcode.solution.array

class Solution3701 {
    fun alternatingSum(nums: IntArray): Int {
        return nums.withIndex().sumOf { (i, x) -> if (i % 2 == 0) x else -x  }
    }
}

fun main() {
    val solution = Solution3701()
    check(solution.alternatingSum(intArrayOf(1,3,5,7)) == -4) {"test1 wrong result"}
    check(solution.alternatingSum(intArrayOf(100)) == 100) {"test2 wrong result"}
}
