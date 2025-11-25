package com.leetcode.solution.math

class Solution2578 {
    fun splitNum(num: Int): Int {
        val arr = num.toString().map { it }.sorted()
        var s1 = ""
        var s2 = ""
        for (i in 0 until arr.size) {
            if (i % 2 == 0)
                s1 += arr[i]
            else
                s2 += arr[i]
        }
        return s1.toInt() + s2.toInt()
    }
}

fun main() {
    val solution = Solution2578()
    check(solution.splitNum(4325) == 59) {"test1"}
    check(solution.splitNum(687) == 75) {"test2"}
}
