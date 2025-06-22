package com.leetcode.solution.math

import kotlin.math.max

class SolutionQ3560 {
    fun minCuttingCost(n: Int, m: Int, k: Int) = maxOf(n - k, m - k, 0) * k.toLong()

    fun minCuttingCost2(n: Int, m: Int, k: Int) = max(max(n - k, m - k), 0) * k.toLong()

    fun minCuttingCost1(n: Int, m: Int, k: Int): Long {
        return max(max(n - k, m - k), 0) * k.toLong()
    }
}

fun main() {
    val solution = SolutionQ3560()
    check(solution.minCuttingCost(6, 5, 5) == 5L) {"wrong result"}
    check(solution.minCuttingCost(4, 4, 6) == 0L) {"wrong result"}
}