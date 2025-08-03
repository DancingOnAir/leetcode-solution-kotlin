package com.leetcode.solution.math

class Solution1025 {
    fun divisorGame(n: Int): Boolean {
        return n % 2 == 0
    }
}

fun main() {
    val solution = Solution1025()
    check(solution.divisorGame(2)) { "testing1 wrong result" }
    check(!solution.divisorGame(3)) { "testing1 wrong result" }
}