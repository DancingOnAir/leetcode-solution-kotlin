package com.leetcode.solution.math

class Solution3099 {
    fun sumOfTheDigitsOfHarshadNumber(x: Int) = x.toString().sumOf { it.digitToInt() }.takeIf { x % it == 0 } ?: -1

    fun sumOfTheDigitsOfHarshadNumber2(x: Int): Int {
        if (x <= 0)
            return -1
        val digitalSum = x.toString().sumOf { it.digitToInt() }
        return digitalSum.takeIf { x % digitalSum == 0 } ?: -1
    }

    fun sumOfTheDigitsOfHarshadNumber1(x: Int): Int {
        val tot = x.toString().map{ it.digitToInt() }.sum()
        if (x % tot == 0)
            return tot
        return -1
    }
}

fun main() {
    val solution = Solution3099()
    check(solution.sumOfTheDigitsOfHarshadNumber(18) == 9) {"wrong result"}
    check(solution.sumOfTheDigitsOfHarshadNumber(23) == -1) {"wrong result"}
}
