package com.leetcode.solution.array

class Solution3683 {
    fun earliestTime(tasks: Array<IntArray>): Int {
        return tasks.minOf { it[0] + it[1] }
    }
}

fun main() {
    val solution = Solution3683()
    check(solution.earliestTime(arrayOf(intArrayOf(1,6), intArrayOf(2,3))) == 5) {"testing1 wrong result"}
    check(solution.earliestTime(arrayOf(intArrayOf(100,100), intArrayOf(100,100), intArrayOf(100,100))) == 200) {"testing2 wrong result"}
}