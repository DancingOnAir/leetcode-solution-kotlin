package com.leetcode.solution.math

import kotlin.math.abs

class Solution2582 {
    fun passThePillow(n: Int, time: Int): Int {
        return n - abs(n - 1 - time % (2 * n - 2))
    }

    fun passThePillow1(n: Int, time: Int): Int {
        val r = time % (2 * n - 2)
        return if (r + 1 <= n) return r + 1 else 2 * n - r - 1
    }
}

fun main() {
    val solution = Solution2582()
    check(solution.passThePillow(4,5) == 2) { "wrong result" }
    check(solution.passThePillow(3,2) == 3) { "wrong result" }
}
