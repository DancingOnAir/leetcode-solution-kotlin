package com.leetcode.solution.math

class Solution3736 {
    fun minMoves(nums: IntArray): Int {
        return nums.sumOf { nums.max() - it }
    }
}

fun main() {
    val solution = Solution3736()
    check(solution.minMoves(intArrayOf(2,1,3)) == 3) {"test1"}
    check(solution.minMoves(intArrayOf(4,4,5)) == 2) {"test2"}
}
