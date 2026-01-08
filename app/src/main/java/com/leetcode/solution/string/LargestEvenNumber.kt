package com.leetcode.solution.string

class Solution3798 {
    fun largestEven(s: String): String {
        for (i in s.lastIndex downTo 0) {
            if (s[i] == '2')
                return s.substring(0, i + 1)
        }
        return ""
    }
}

fun main() {
    val solution = Solution3798()
    check(solution.largestEven("1112") == "1112") {"test1"}
    check(solution.largestEven("221") == "22") {"test2"}
    check(solution.largestEven("1") == "") {"test3"}
}
