package com.leetcode.solution.math

import kotlin.math.min

class Solution2427 {
    fun commonFactors(a: Int, b: Int): Int {
        return (1..min(a, b)).count { a % it == 0 && b % it == 0 }
    }

    fun commonFactors1(a: Int, b: Int): Int {
        var res = 0
        for (i in 1..min(a, b)) {
            if (a % i == 0 && b % i == 0)
                res++
        }
        return res
    }
}

fun main() {
    val solution = Solution2427()
    check(solution.commonFactors(12, 6) == 4) {"test1"}
    check(solution.commonFactors(25, 30) == 2) {"test1"}
}
