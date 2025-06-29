package com.leetcode.solution.math

import kotlin.math.sqrt

class Solution3591 {
    fun isPrime(num: Int): Boolean {
        if (num <= 1)
            return false
        if (num <= 3)
            return true
        if (num % 2 == 0 || num % 3 == 0)
            return false

        val sqrt = sqrt(num.toDouble()).toInt()
        for (i in generateSequence(5) { it + 6 }.takeWhile { it <= sqrt }) {
            if (num % i == 0 || num % (i + 2) == 0)
                return false
        }
        return true
    }

    fun checkPrimeFrequency(nums: IntArray): Boolean {
        var m = mutableMapOf<Int, Int>()
        for (x in nums) {
            m[x] = m.getOrDefault(x, 0) + 1
        }
        for (x in m.values) {
            if (isPrime(x))
                return true
        }
        return false
    }
}

fun main() {
    val solution = Solution3591()
    check(solution.checkPrimeFrequency(intArrayOf(1,2,3,4,5,4))) {"wrong result"}
    check(!solution.checkPrimeFrequency(intArrayOf(1,2,3,4,5))) {"wrong result"}
    check(solution.checkPrimeFrequency(intArrayOf(2,2,2,4,4))) {"wrong result"}
}
