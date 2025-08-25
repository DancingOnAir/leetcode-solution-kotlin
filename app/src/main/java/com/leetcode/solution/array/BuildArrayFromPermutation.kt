package com.leetcode.solution.array

class Solution1920 {
    fun buildArray(nums: IntArray): IntArray {
        return nums.indices.map { nums[nums[it]] }.toIntArray()
    }
}

fun main() {
    val solution = Solution1920()
    check(solution.buildArray(intArrayOf(0,2,1,5,3,4)).contentEquals(intArrayOf(0,1,2,4,5,3))) {"testing1 wrong result"}
    check(solution.buildArray(intArrayOf(5,0,1,2,3,4)).contentEquals(intArrayOf(4,5,0,1,2,3))) {"testing2 wrong result"}
}
