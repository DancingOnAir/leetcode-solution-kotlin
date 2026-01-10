package com.leetcode.solution.string

class Solution3794 {
    fun reversePrefix(s: String, k: Int): String {
        return s.substring(0, k).reversed() + s.substring(k)
    }
}

fun main() {
    val solution = Solution3794()
    check(solution.reversePrefix("abcd", 2) == "bacd") {"test1"}
    check(solution.reversePrefix("xyz", 3) == "zyx") {"test2"}
    check(solution.reversePrefix("hey", 1) == "hey") {"test3"}
}
