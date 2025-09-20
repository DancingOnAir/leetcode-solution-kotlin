package com.leetcode.solution.array.twoPoints

import kotlin.math.max
import kotlin.math.min

class Solution3633 {
    fun earliestFinishTime(landStartTime: IntArray, landDuration: IntArray, waterStartTime: IntArray, waterDuration: IntArray): Int {
        fun helper(firstTime: IntArray, firstDuration: IntArray, secondTime: IntArray, secondDuration: IntArray): Int {
            val firstEnd = firstTime.zip(firstDuration).minOf { (a, b) -> a + b }
            var res = Int.MAX_VALUE
            for (i in secondTime.indices) {
                res = min(res, max(firstEnd, secondTime[i]) + secondDuration[i])
            }
            return res
        }
        return min(helper(landStartTime, landDuration, waterStartTime, waterDuration), helper(waterStartTime, waterDuration, landStartTime, landDuration))
    }
}

fun main() {
    val solution = Solution3633()
    check(solution.earliestFinishTime(intArrayOf(2,8), intArrayOf(4,1), intArrayOf(6), intArrayOf(3)) == 9) {"test1 wrong result"}
    check(solution.earliestFinishTime(intArrayOf(5), intArrayOf(3), intArrayOf(1), intArrayOf(10)) == 14) {"test2 wrong result"}
}
