package com.leetcode.solution.greedy

class Solution3557 {
    fun maxSubstrings(word: String): Int {
        val m = mutableMapOf<Char, Int>()
        var res = 0
        for ((i, c) in word.withIndex()) {
            if (!m.contains(c)) {
                m[c] = i
            }
            else if (i - m.getOrDefault(c, 0) > 2) {
                m.clear()
                ++res
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution3557()
    check(solution.maxSubstrings("abcdeafdef") == 2) {"test1"}
    check(solution.maxSubstrings("bcdaaaab") == 1) {"test2"}
}
