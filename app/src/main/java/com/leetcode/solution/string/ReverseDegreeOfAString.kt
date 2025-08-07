package com.leetcode.solution.string

class Solution3498 {
    fun reverseDegree(s: String): Int {
        return s.withIndex().sumOf { (i, c) -> (26 - (c - 'a')) * (i + 1) }
    }
}

fun main() {
    val solution = Solution3498()
    check(solution.reverseDegree("abc") == 148) { "testing1 wrong result" }
    check(solution.reverseDegree("zaza") == 160) { "testing2 wrong result" }
}
