package com.leetcode.solution.math

class Solution2180 {
    fun countEven(num: Int): Int {
        return (1 .. num).count { it.toString().sumOf { it.digitToInt() } % 2 == 0 }
    }
}

fun main() {
    val solution = Solution2180()
    check(solution.countEven(4) == 2) { "wrong result" }
    check(solution.countEven(30) == 14) { "wrong result" }
}
