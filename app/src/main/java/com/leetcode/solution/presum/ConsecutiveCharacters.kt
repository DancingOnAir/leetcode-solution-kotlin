package com.leetcode.solution.presum

import kotlin.math.max

class Solution1446 {
    fun maxPower(s: String): Int {
        val n = s.length
        var res = 1
        var i = 0
        while (i < n) {
            val start = i
            i++
            while (i < n && s[i] == s[i - 1]) {
                i++
            }
            res = max(res, i - start)
        }
        return res
    }
}

fun main() {
    val solution = Solution1446()
    check(solution.maxPower("cc") == 2) {"test3"}
    check(solution.maxPower("leetcode") == 2) {"test1"}
    check(solution.maxPower("abbcccddddeeeeedcba") == 5) {"test2"}
}
