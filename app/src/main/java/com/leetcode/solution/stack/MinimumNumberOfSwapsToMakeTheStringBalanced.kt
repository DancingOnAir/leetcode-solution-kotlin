package com.leetcode.solution.stack

class Solution1963 {
    fun minSwaps(s: String): Int {
        var open_bracket = 0
        for (c in s) {
            if (c == '[' || open_bracket == 0)
                ++open_bracket
            else
                --open_bracket
        }
        return open_bracket / 2
    }

    fun minSwaps1(s: String): Int {
        var open_bracket = 0
        for (c in s) {
            if (c == '[') {
                ++open_bracket
            }
            else {
                if (open_bracket > 0) {
                    --open_bracket
                }
            }
        }
        // 最后形如 '...]]] ... [[[ ..' 需要(x + 1) / 2次交换
        return (open_bracket + 1) / 2
    }
}

fun main() {
    val solution = Solution1963()
    check(solution.minSwaps("][][") == 1) {"test1"}
    check(solution.minSwaps("]]][[[") == 2) {"test2"}
    check(solution.minSwaps("[]") == 0) {"test3"}
}
