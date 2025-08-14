package com.leetcode.solution.array

class Solution2778 {
    fun sumOfSquares(nums: IntArray): Int {
        return nums.withIndex().sumOf { (i, x) -> if (nums.size % (i + 1) == 0) x * x else 0 }
    }
}

fun main() {
    val solution = Solution2778()
    check(solution.sumOfSquares(intArrayOf(1,2,3,4)) == 21) {"testing1 wrong result"}
    check(solution.sumOfSquares(intArrayOf(2,7,1,19,18,3)) == 63) {"testing2 wrong result"}
}