package com.leetcode.solution.math

class Solution2169 {
    fun countOperations(num1: Int, num2: Int): Int {
        when {
            num1 == 0 || num2 == 0 -> return 0
            num1 > num2 -> return num1 / num2 + countOperations(num1 % num2, num2)
            else -> return num2 / num1 + countOperations(num1, num2 % num1)
        }
    }
}

fun main() {
    val solution = Solution2169()
    check(solution.countOperations(2, 3) == 3) { "wrong result" }
    check(solution.countOperations(10, 10) == 1) { "wrong result" }
}
