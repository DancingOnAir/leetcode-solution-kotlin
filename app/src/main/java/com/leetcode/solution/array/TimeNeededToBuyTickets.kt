package com.leetcode.solution.array

import kotlin.math.min

class Solution2073 {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        return tickets.withIndex().sumOf { (i, x) -> if (i <= k) min(x, tickets[k]) else min(x, tickets[k] - 1) }
    }
}

fun main() {
    val solution = Solution2073()
    check(solution.timeRequiredToBuy(intArrayOf(2,3,2),2) == 6) {"testing1 wrong result"}
    check(solution.timeRequiredToBuy(intArrayOf(5,1,1,1),0) == 8) {"testing2 wrong result"}
}