package com.leetcode.solution.math

class Solution2119 {
    fun isSameAfterReversals(num: Int): Boolean {
        return num % 10 != 0 || num == 0
    }
}

fun main() {
    val solution = Solution2119()
    check(solution.isSameAfterReversals(526)) { "wrong result" }
    check(!solution.isSameAfterReversals(1800)) { "wrong result" }
    check(solution.isSameAfterReversals(0)) { "wrong result" }
}
