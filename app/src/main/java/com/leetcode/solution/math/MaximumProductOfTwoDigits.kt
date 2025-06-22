package com.leetcode.solution.math

class SolutionQ3536 {
    fun maxProduct(n: Int): Int {
        require(n >= 10)
        val digits = n.toString()
            .map{ it.digitToInt() }
            .sortedDescending()
        return digits.take(2).let { it[0] * it[1] }
//        return digits[0] * digits[1]
    }
}

fun main() {
    val solution = SolutionQ3536()
    check(solution.maxProduct(31) == 3) {"wrong result"}
    check(solution.maxProduct(22) == 4) {"wrong result"}
    check(solution.maxProduct(124) == 8) {"wrong result"}
}
