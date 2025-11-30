package com.leetcode.solution.bitManipulation


class Solution3750 {
    fun minimumFlips(n: Int): Int {
        return (n xor n.toString(2).reversed().toInt(2)).countOneBits()
    }
}

fun main() {
    val solution = Solution3750()
    check(solution.minimumFlips(7) == 0) {"test1"}
    check(solution.minimumFlips(10) == 4) {"test2"}
}