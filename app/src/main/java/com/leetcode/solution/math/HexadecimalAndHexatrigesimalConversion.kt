package com.leetcode.solution.math

class Solution3602 {
    fun concatHex36(n: Int): String {
        return (n * n).toString(16).uppercase() + (n * n * n).toString(36).uppercase()
    }
}

fun main() {
    val solution = Solution3602()
    check(solution.concatHex36(13) == "A91P1") { "wrong result" }
    check(solution.concatHex36(36) == "5101000") { "wrong result" }
}
