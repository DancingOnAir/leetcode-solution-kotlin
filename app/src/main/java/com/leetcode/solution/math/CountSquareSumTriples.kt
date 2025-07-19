package com.leetcode.solution.math

import kotlin.math.sqrt

class Solution1925 {
    fun countTriples(n: Int): Int {
        var res = 0
        for (i in 1..n - 2) {
            for (j in i+1..n-1) {
                val x = sqrt((i * i + j * j).toDouble())
                if (x % 1 == 0.0 && x <= n)
                    res += 2
            }
        }
        return res
    }

    fun countTriples1(n: Int): Int {
        if (n < 3)
            return 0

        var res = 0
        for (i in 1..n - 2) {
            for (j in i+1..n-1) {
                for (k in j+1..n) {
                    if (i * i + j * j == k * k)
                        res += 2
                }
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution1925()
    check(solution.countTriples(5) == 2) { "wrong result" }
    check(solution.countTriples(10) == 4) { "wrong result" }
}
