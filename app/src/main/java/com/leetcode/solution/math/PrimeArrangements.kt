package com.leetcode.solution.math

import kotlin.math.sqrt

class Solution1175 {
    fun numPrimeArrangements(n: Int): Int {
        fun Int.isPrime(): Boolean {
            return when {
                this == 2 || this == 3 -> true
                this <= 1 || this % 2 == 0 || this % 3 == 0 -> return false
                else -> {
                    val root = sqrt(this.toDouble()).toInt()
                    for (x in 5..root step 6) {
                        if (this % x == 0 || this % (x + 2) == 0)
                            return false
                    }
                    return true
                }
            }
        }

        var cnt = 0
        for (x in 1..n) {
            if (x.isPrime())
                cnt += 1
        }

        var res = 1L
        val mod = 1e9.toInt() + 7
        for (i in cnt downTo 1) res = res * i % mod // factorial(countOfPrimes)
        for (i in n - cnt downTo 1) res = res * i % mod // factorial(n - countOfPrimes) * prev step

        return res.toInt()
    }
}

fun main() {
    val solution = Solution1175()
    check(solution.numPrimeArrangements(5) == 12) {"test1 wrong result"}
    check(solution.numPrimeArrangements(100) == 682289015) {"test2 wrong result"}
}
