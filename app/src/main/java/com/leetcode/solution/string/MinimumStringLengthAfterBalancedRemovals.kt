package com.leetcode.solution.string

import kotlin.math.abs

class Solution3746 {
    fun minLengthAfterRemovals(s: String): Int {
        return abs(s.count { it == 'a' } * 2 - s.length)
    }

    fun minLengthAfterRemovals1(s: String): Int {
        var res = 0
        for (c in s) {
            if (c == 'a') {
                res++
            }
            else {
                res--
            }
        }

        return abs(res)
    }
}

fun main() {
    val solution = Solution3746()
    check(solution.minLengthAfterRemovals("aabbab") == 0) {"test1"}
    check(solution.minLengthAfterRemovals("aaaa") == 4) {"test2"}
    check(solution.minLengthAfterRemovals("aaabb") == 1) {"test3"}
}
