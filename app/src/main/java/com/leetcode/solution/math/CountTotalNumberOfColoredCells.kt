package com.leetcode.solution.math

class Solution2579 {
    // 1 + (1 + 2 + 3 + n - 1) * 4 = 1 + n * (n - 1) * 2
    fun coloredCells(n: Int): Long {
        return 2L * n * n - 2L * n + 1
    }
}

fun main() {
    val solution = Solution2579()
    check(solution.coloredCells(1) == 1L) {"test1"}
    check(solution.coloredCells(2) == 5L) {"test2"}
    check(solution.coloredCells(3) == 13L) {"test3"}
}
