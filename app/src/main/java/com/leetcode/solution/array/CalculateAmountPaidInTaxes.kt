package com.leetcode.solution.array

import kotlin.math.abs

class Solution2303 {
    fun calculateTax(brackets: Array<IntArray>, income: Int): Double {
        var res = 0.0
        var pre = 0
        for ((u, p) in brackets) {
            if (income > u) {
                res += ((u - pre) * p).toDouble() / 100
                pre = u
            } else {
                res += ((income - pre) * p).toDouble() / 100
                break
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution2303()
    check(abs(solution.calculateTax(arrayOf(intArrayOf(3,50),intArrayOf(7,10),intArrayOf(12,25)),10) - 2.65000) < 1e-5) {"testing1 wrong result"}
    check(abs(solution.calculateTax(arrayOf(intArrayOf(1,0),intArrayOf(4,25),intArrayOf(5,50)),2) - 0.25000) < 1e-5) {"testing2 wrong result"}
    check(abs(solution.calculateTax(arrayOf(intArrayOf(2,50)),0) - 0.00000) < 1e-5) {"testing3 wrong result"}
}
