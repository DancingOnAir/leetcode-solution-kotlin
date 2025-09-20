package com.leetcode.solution.array.twoPoints

import kotlin.math.max
import kotlin.math.min

class Solution3635 {
    fun earliestFinishTime(landStartTime: IntArray, landDuration: IntArray, waterStartTime: IntArray, waterDuration: IntArray): Int {
        fun helper(firstTime: IntArray, firstDuration: IntArray, secondTime: IntArray, secondDuration: IntArray): Int {
            val firstEnd = firstTime.zip(firstDuration).minOf { (a, b) -> a + b }
            return secondTime.zip(secondDuration).minOf { (a, b) -> max(a, firstEnd) + b }
        }
        return min(helper(landStartTime, landDuration, waterStartTime, waterDuration), helper(waterStartTime, waterDuration, landStartTime, landDuration))
    }
}

fun main() {
    val solution = Solution3635()
    check(solution.earliestFinishTime(intArrayOf(2,8), intArrayOf(4,1), intArrayOf(6), intArrayOf(3)) == 9) {"test1 wrong result"}
    check(solution.earliestFinishTime(intArrayOf(5), intArrayOf(3), intArrayOf(1), intArrayOf(10)) == 14) {"test2 wrong result"}
}
