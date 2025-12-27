package com.leetcode.solution.hashtable

import kotlin.math.max

class Solution3784 {
    fun minCost(s: String, cost: IntArray): Long {
        val m = mutableMapOf<Char, Long>()
        var tot = 0L
        var mx = Long.MIN_VALUE
        for ((i, c) in s.withIndex()) {
            tot += cost[i]
            m[c] = m.getOrDefault(c, 0L) + cost[i]
            mx = max(mx, m[c]!!)
        }
        return tot - mx
    }
}

fun main() {
    val solution = Solution3784()
    check(solution.minCost("aabaac", intArrayOf(1,2,3,4,1,10)) == 11L) {"test1"}
    check(solution.minCost("abc", intArrayOf(10,5,8)) == 13L) {"test2"}
    check(solution.minCost("zzzzz", intArrayOf(67,67,67,67,67)) == 0L) {"test3"}
}
