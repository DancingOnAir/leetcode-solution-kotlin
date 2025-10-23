package com.leetcode.solution.bitManipulation

import kotlin.math.max

class Solution0868 {
    fun binaryGap(n: Int): Int {
        var pre = -1
        var res = 0
        for ((i, c) in n.toString(2).withIndex()) {
            if (c == '1') {
                if (pre != -1) {
                    res = max(res, i - pre)
                }
                pre = i
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution0868()
    check(solution.binaryGap(22) == 2) {"test1 wrong result"}
    check(solution.binaryGap(8) == 0) {"test2 wrong result"}
    check(solution.binaryGap(5) == 2    ) {"test3 wrong result"}
}
