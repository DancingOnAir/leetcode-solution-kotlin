package com.leetcode.solution.array

import kotlin.math.min

class Solution3502 {
    fun minCosts(cost: IntArray): IntArray {
        val res = IntArray(cost.size)
        var cur = Int.MAX_VALUE
        for (i in 0..cost.size - 1) {
            cur = min(cur, cost[i])
            res[i] = cur
        }
        return res
    }

    fun minCosts1(cost: IntArray): IntArray {
        var res = mutableListOf(cost[0])
        for (i in 1..cost.size-1) {
            if (cost[i] < res.last())
                res.add(cost[i])
            else
                res.add(res.last())
        }
        return res.toIntArray()
    }
}

fun main() {
    val solution = Solution3502()
    check(solution.minCosts(intArrayOf(5,3,4,1,3,2)).contentEquals((intArrayOf(5,3,3,1,1,1))))
    check(solution.minCosts(intArrayOf(1,2,4,6,7)).contentEquals(intArrayOf(1,1,1,1,1)))
}
