package com.leetcode.solution.string

class Solution1541 {
    fun minInsertions(s: String): Int {
        var left = 0
        var res = 0
        var i = 0
        while (i < s.length) {
            if (s[i] == '(') {
                left++
            }
            else {
                if (i < s.lastIndex && s[i + 1] == ')') {
                    ++i
                }
                else {
                    ++res
                }
                if (left > 0) {
                    --left
                }
                else {
                    ++res
                }
            }
            ++i
        }

        return left * 2 + res
    }
}

fun main() {
    val solution = Solution1541()
    check(solution.minInsertions("(()))") == 1) {"test1"}
    check(solution.minInsertions("())") == 0) {"test2"}
    check(solution.minInsertions("))())(") == 3) {"test3"}
}
