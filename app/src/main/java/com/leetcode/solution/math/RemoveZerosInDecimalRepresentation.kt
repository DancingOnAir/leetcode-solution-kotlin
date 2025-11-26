package com.leetcode.solution.math

class Solution3726 {
    fun removeZeros(n: Long): Long {
        if (n == 0L)
            return n
        if (n % 10 == 0L)
            return removeZeros(n / 10)
        return removeZeros(n / 10) * 10 + n % 10
    }

    fun removeZeros1(n: Long): Long {
        return n.toString().map { if (it == '0') "" else it }.joinToString("").toLong()
    }
}

fun main() {
    val solution = Solution3726()
    check(solution.removeZeros(1020030L) == 123L) {"test1"}
    check(solution.removeZeros(1L) == 1L) {"test2"}
}

