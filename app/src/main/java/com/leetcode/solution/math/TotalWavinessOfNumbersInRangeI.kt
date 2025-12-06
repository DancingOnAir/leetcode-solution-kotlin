package com.leetcode.solution.math

import kotlin.math.max

class Solution3751 {
    // concise idiomatic solution
    fun totalWaviness(num1: Int, num2: Int): Int {
        fun Int.waviness() =
            toString()
            .windowed(3)
            .count { s -> s[1] > s[0] && s[1] > s[2] || s[1] < s[0] && s[1] < s[2] }

        return (max(100, num1)..num2).sumOf { it.waviness() }
    }

    fun totalWaviness1(num1: Int, num2: Int): Int {
        fun getNumOfWaviness(num: Int): Int {
            if (num < 100)
                return 0

            val s = num.toString()
            var cnt = 0
            for (i in 1..s.lastIndex - 1) {
                if ((s[i] > s[i - 1] && s[i] > s[i + 1]) || (s[i] < s[i - 1] && s[i] < s[i + 1])) {
                    cnt++
                }
            }
            return cnt
        }

        var res = 0
        for (x in num1..num2) {
            res += getNumOfWaviness(x)
        }
        return res
    }
}

fun main() {
    val solution = Solution3751()
    check(solution.totalWaviness(120, 130) == 3) {"test1"}
    check(solution.totalWaviness(198, 202) == 3) {"test2"}
    check(solution.totalWaviness(4848, 4848) == 2) {"test3"}
}
