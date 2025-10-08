package com.leetcode.solution.heap

import kotlin.math.max

class Solution3572 {
    fun maxSumDistinctTriplet(x: IntArray, y: IntArray): Int {
        val m = mutableMapOf<Int, Int>()
        for ((i, v) in x.withIndex()) {
            m[v] = max(m.getOrDefault(v, 0), y[i])
        }

        if (m.size < 3)
            return -1
        return m.values.sortedDescending().take(3).sum()
    }
}

fun main() {
    val solution = Solution3572()
    check(solution.maxSumDistinctTriplet(intArrayOf(1,2,1,3,2), intArrayOf(5,3,4,6,2)) == 14) { "test1 wrong result" }
    check(solution.maxSumDistinctTriplet(intArrayOf(1,2,1,2), intArrayOf(4,5,6,7)) == -1) { "test2 wrong result" }
}
