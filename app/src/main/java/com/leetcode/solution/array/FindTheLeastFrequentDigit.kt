package com.leetcode.solution.array

class Solution3663 {
    fun getLeastFrequentDigit(n: Int): Int {
        val m = n.toString().groupingBy { it }.eachCount()
        val res = m.minWithOrNull(compareBy<Map.Entry<Char, Int>> { it.value }.thenBy { it.key })?.key
        return res!!.digitToInt()
    }
}

fun main() {
    val solution = Solution3663()
    check(solution.getLeastFrequentDigit(1553322) == 1) {"test1 wrong result"}
    check(solution.getLeastFrequentDigit(723344511) == 2) {"test2 wrong result"}
}
