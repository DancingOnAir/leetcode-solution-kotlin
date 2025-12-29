package com.leetcode.solution.stack

class Solution0921 {
    fun minAddToMakeValid(s: String): Int {
        var open_bracket = 0
        var res = 0
        for (c in s) {
            if (c == '(') {
                ++open_bracket
            }
            else {
                if (open_bracket > 0)
                    --open_bracket
                else
                    ++res
            }
        }

        return open_bracket + res
    }
}

fun main() {
    val solution = Solution0921()
    check(solution.minAddToMakeValid("()))((") == 4) {"test3"}
    check(solution.minAddToMakeValid("())") == 1) {"test1"}
    check(solution.minAddToMakeValid("(((") == 3) {"test2"}
}
