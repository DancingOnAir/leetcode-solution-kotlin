package com.leetcode.solution.greedy

class Solution3781 {
    fun maximumScore(nums: IntArray, s: String): Long {
        val n = s.count { it == '1' }
        val x = nums.sortedDescending().take(n)
        return nums.sortedDescending().take(n).sum().toLong()
    }
}

fun main() {
    val solution = Solution3781()
    check(solution.maximumScore(intArrayOf(2,1,5,2,3), "01010") == 7L) {"test1"}
    check(solution.maximumScore(intArrayOf(4,7,2,9), "0000") == 0L) {"test2"}
}
