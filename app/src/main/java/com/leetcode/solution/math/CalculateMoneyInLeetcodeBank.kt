package com.leetcode.solution.math

class Solution1716 {
    fun totalMoney(n: Int): Int {
        val q = n / 7
        val r = n % 7
        return (7 * q * q + 49 * q + (2 * q + r + 1) * r) / 2
    }
}

fun main() {
    val solution = Solution1716()
    check(solution.totalMoney(4) == 10) { "wrong result" }
    check(solution.totalMoney(10) == 37) { "wrong result" }
    check(solution.totalMoney(20) == 96) { "wrong result" }
}
