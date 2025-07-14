package com.leetcode.solution.math

class Solution2160 {
    fun minimumSum(num: Int): Int {
        val digits = num.toString().map { it.digitToInt() }.toIntArray()
        digits.sort()
        return digits[0] * 10 + digits[2] + digits[1] * 10 + digits[3]
    }
}

fun main() {
    val solution = Solution2160()
    check(solution.minimumSum(2932) == 52) { "wrong result" }
    check(solution.minimumSum(4009) == 13) { "wrong result" }
}
