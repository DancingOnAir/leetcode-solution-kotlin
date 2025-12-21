package com.leetcode.solution.math

import kotlin.math.max
import kotlin.math.sqrt

class Solution3770 {
    fun sieveOfEratosthenes(n: Int): List<Int> {
        if (n < 2)
            return emptyList()

        val isPrime = BooleanArray(n + 1) { true }
        isPrime[0] = false
        isPrime[1] = false
        for (i in 2..sqrt(n.toDouble()).toInt()) {
            if (isPrime[i]) {
                for (j in i * i..n step i) {
                    isPrime[j] = false
                }
            }
        }
        return (2..n).filter { isPrime[it] }
    }

    fun largestPrime(n: Int): Int {
        val primes = sieveOfEratosthenes(n)
        var res = 0
        for (x in primes) {
            res += x
            if (res > n) {
                res -= x
                break
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution3770()
    check(solution.largestPrime(20) == 17) {"test1"}
    check(solution.largestPrime(2) == 2) {"test2"}
}