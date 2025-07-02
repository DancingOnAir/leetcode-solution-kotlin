package com.leetcode.solution.math

class Solution2769 {
    fun theMaximumAchievableX(num: Int, t: Int) = num + t * 2
}

fun main() {
    val solution = Solution2769()
    check(solution.theMaximumAchievableX(4, 1) == 6) { "wrong result" }
    check(solution.theMaximumAchievableX(3, 2) == 7) { "wrong result" }
}
