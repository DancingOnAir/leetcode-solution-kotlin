package com.leetcode.solution.math

class Solution3648 {
    fun minSensors(n: Int, m: Int, k: Int): Int {
        val d = (2 * k + 1)
        return ((n - 1 + d) / d) * ((m - 1 + d) / d)
    }

    fun minSensors1(n: Int, m: Int, k: Int): Int {
        val d = 2 * k + 1
        val cntCol = m / d + if (m % d == 0) 0 else 1
        val cntRow = n / d + if (n % d == 0) 0 else 1
        return cntRow * cntCol
    }
}

fun main() {
    val solution = Solution3648()
    check(solution.minSensors(5, 5, 1) == 4) {"test1"}
    check(solution.minSensors(2, 2, 2) == 1) {"test2"}
}
