package com.leetcode.solution.math

class Solution2843 {
    fun countSymmetricIntegers(low: Int, high: Int): Int {
        return (low .. high).count { i -> i.toString().run { length % 2 == 0 && take(length / 2).sumOf { it.digitToInt() } == takeLast(length / 2).sumOf { it.digitToInt() } } }
    }

    fun countSymmetricIntegers1(low: Int, high: Int): Int {
        var res = 0
        for (i in low .. high) {
            var s = i.toString()
            val n = s.length
            val firstHalf = s.substring(0, n / 2).sumOf { it.digitToInt() }
            val secondHalf = s.substring( n / 2).sumOf { it.digitToInt() }
            if (n % 2 == 0 && firstHalf == secondHalf) {
                res += 1
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution2843()
    check(solution.countSymmetricIntegers(1, 100) == 9) {"wrong result"}
    check(solution.countSymmetricIntegers(1200, 1230) == 4) {"wrong result"}
}
