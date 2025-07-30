package com.leetcode.solution.math

class Solution1281 {
    fun subtractProductAndSum(n: Int): Int {
        val digits = n.toString().map { it.digitToInt() }
        val product = digits.fold(1) { acc, i -> acc * i }
        return product - digits.sum()
    }
}

fun main() {
    val solution = Solution1281()
    check(solution.subtractProductAndSum(234) == 15) {"test1 wrong result"}
    check(solution.subtractProductAndSum(4421) == 21) {"test2 wrong result"}
}
