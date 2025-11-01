package com.leetcode.solution.array

class Solution1207 {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val m = arr.asList().groupingBy { it }.eachCount()
        return m.size == m.values.toSet().size
    }
}

fun main() {
    val solution = Solution1207()
    check(solution.uniqueOccurrences(intArrayOf(1,2,2,1,1,3))) {"test1 wrong result"}
    check(!solution.uniqueOccurrences(intArrayOf(1,2))) {"test2 wrong result"}
    check(solution.uniqueOccurrences(intArrayOf(-3,0,1,-3,1,1,1,-3,10,0))) {"test3 wrong result"}
}
