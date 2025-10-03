package com.leetcode.solution.array

class Solution3684 {
    fun maxKDistinct(nums: IntArray, k: Int): IntArray {
        return nums.toSet().sortedDescending().take(k).toIntArray()
    }
}

fun main() {
    val solution = Solution3684()
    check(solution.maxKDistinct(intArrayOf(84,93,100,77,90),3) == intArrayOf(100,93,90)) { "test1 wrong result" }
    check(solution.maxKDistinct(intArrayOf(84,93,100,77,93),3) == intArrayOf(100,93,84)) { "test2 wrong result" }
}