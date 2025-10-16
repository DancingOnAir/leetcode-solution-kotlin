package com.leetcode.solution.string

class Solution3707 {
    fun scoreBalance(s: String): Boolean {
        val ps = mutableSetOf<Int>()
        var tot = 0
        for (c in s) {
            tot += (c - 'a' + 1)
            ps.add(tot)
        }
        if (tot % 2 == 1)
            return false
        return ps.contains(tot / 2)
    }
}

fun main() {
    val solution = Solution3707()
    check(solution.scoreBalance("adcb")) {"test1 wrong result"}
    check(!solution.scoreBalance("bace")) {"test2 wrong result"}
    check(!solution.scoreBalance("edb")) {"test3 wrong result"}
}
