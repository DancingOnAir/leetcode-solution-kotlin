package com.leetcode.solution.greedy

import kotlin.math.max

class Solution3675 {
    fun minOperations(s: String): Int {
        var res = 0
        for (c in s) {
            if (c != 'a')
                res = max(res, 26 - (c - 'a'))
            if (res == 25)
                break
        }
        return res
    }
}

fun main() {
    val solution = Solution3675()
    check(solution.minOperations("yz") == 2) {"test1"}
    check(solution.minOperations("a") == 0) {"test2"}
}
