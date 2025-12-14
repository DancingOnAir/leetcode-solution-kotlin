package com.leetcode.solution.array

class Solution3769 {
    fun sortByReflection(nums: IntArray): IntArray {
        return nums.sortedWith( compareBy<Int> { it.toString(2).reversed().toInt(2) }.thenBy { it } ).toIntArray()
    }
}

fun main() {
    val solution = Solution3769()
    check(solution.sortByReflection(intArrayOf(947881,309856)).contentEquals(intArrayOf(309856, 947881))) {"test3"}
    check(solution.sortByReflection(intArrayOf(4,5,4)).contentEquals(intArrayOf(4,4,5))) {"test1"}
    check(solution.sortByReflection(intArrayOf(3,6,5,8)).contentEquals(intArrayOf(8,3,6,5))) {"test2"}
}
