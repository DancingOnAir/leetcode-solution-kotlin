package com.leetcode.solution.math

import kotlin.math.min

class Solution2739 {
    fun distanceTraveled(mainTank: Int, additionalTank: Int): Int {
        var transferTimes = (mainTank - 1) / 4
        transferTimes = min(transferTimes, additionalTank)
        return (mainTank + transferTimes) * 10
    }

    fun distanceTraveled1(mainTank: Int, additionalTank: Int): Int {
        var res = 0
        var m = mainTank
        var n = additionalTank
        while (m >= 5) {
            res += 50
            m -= 5
            if (n > 0) {
                n--
                m++
            }
        }
        return res + m * 10
    }
}

fun main() {
    val solution = Solution2739()
    check(solution.distanceTraveled(5, 10) == 60) { "wrong result1" }
    check(solution.distanceTraveled(1, 2) == 10) { "wrong result2" }
}
