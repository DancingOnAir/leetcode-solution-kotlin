package com.leetcode.solution.hashtable

class Solution3731 {
    fun findMissingElements(nums: IntArray): List<Int> {
        nums.sort()
        return (nums.first()..nums.last()).filter { it !in nums }
    }
}

fun main() {
    val solution = Solution3731()
    assert(solution.findMissingElements(intArrayOf(1,4,2,5)) == arrayOf(3))
    assert(solution.findMissingElements(intArrayOf(7,8,6,9)).isEmpty())
    assert(solution.findMissingElements(intArrayOf(5,1)) == arrayOf(2,3,4))
}
