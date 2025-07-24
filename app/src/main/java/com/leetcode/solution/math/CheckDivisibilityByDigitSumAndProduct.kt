package com.leetcode.solution.math

class Solution3622 {
    fun checkDivisibility(n: Int): Boolean {
        var x = n
        var digitalSum = 0
        var digitalProduct = 1
        while (x > 0) {
            digitalSum += x % 10
            digitalProduct *= x % 10
            x /= 10
        }
        return n % (digitalSum + digitalProduct) == 0
    }
}

fun main() {
    val solution = Solution3622()
    check(solution.checkDivisibility(99)) { "wrong result" }
    check(!solution.checkDivisibility(23)) { "wrong result" }
}
