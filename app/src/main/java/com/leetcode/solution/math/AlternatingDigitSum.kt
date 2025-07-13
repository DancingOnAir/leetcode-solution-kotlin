package com.leetcode.solution.math

import kotlin.math.pow

class Solution2544 {
    fun alternateDigitSum(n: Int): Int {
        return n.toString().mapIndexed { i, c -> if (i % 2 == 0) c.digitToInt() else -c.digitToInt() }.sum()
    }

    fun alternateDigitSum1(n: Int): Int {
        var res = 0
        for ((i, x) in n.toString().withIndex()) {
            res += x.digitToInt() * (-1).toDouble().pow(i).toInt()
        }
        return res
    }
}

fun main() {
    val solution = Solution2544()
    check(solution.alternateDigitSum(521) == 4) { "wrong result" }
    check(solution.alternateDigitSum(111) == 1) { "wrong result" }
}
