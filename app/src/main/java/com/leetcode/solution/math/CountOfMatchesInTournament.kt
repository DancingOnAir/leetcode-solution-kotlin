package com.leetcode.solution.math

class Solution1688 {
    fun numberOfMatches(n: Int): Int {
        return n - 1
    }

    fun numberOfMatches1(n: Int): Int {
        var x = n
        var res = 0
        while (x > 1) {
            res += x / 2
            x = x / 2 + (if (x % 2 == 1) 1 else 0)
        }

        return res
    }
}

fun main() {
    val solution = Solution1688()
    check(solution.numberOfMatches(7) == 6) { "wrong result" }
    check(solution.numberOfMatches(14) == 13) { "wrong result" }
}
