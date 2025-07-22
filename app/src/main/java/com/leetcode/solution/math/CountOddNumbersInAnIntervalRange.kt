package com.leetcode.solution.math

class Solution1523 {
    fun countOdds(low: Int, high: Int): Int {
        return (high + 1) / 2 - low / 2
    }

    fun countOdds1(low: Int, high: Int): Int {
        return (high + 2 - low - (if (low % 2 == 0) 1 else 0)) / 2
    }
}

fun main() {
    val solution = Solution1523()
    check(solution.countOdds(3,7) == 3) { "wrong result" }
    check(solution.countOdds(8,10) == 1) { "wrong result" }
}
