package com.leetcode.solution.string

class Solution3760 {
    fun maxDistinct(s: String): Int {
        return s.toSet().size
    }
}

fun main() {
    val solution = Solution3760()
    check(solution.maxDistinct("abab") == 2) {"test1"}
    check(solution.maxDistinct("abcd") == 4) {"test2"}
    check(solution.maxDistinct("aaaa") == 1) {"test3"}
}
