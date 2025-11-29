package com.leetcode.solution.math

class Solution3747 {
    fun countDistinct(n: Long): Long {
        val s = n.toString()
        val m = s.length

        var pow9 = 1L
        repeat(m) {
            pow9 *= 9
        }
        var res = (pow9 - 9) / 8

        for ((i, d) in s.withIndex()) {
            if (d == '0')
                break

            var v = d.digitToInt() - 1
            if (i == m - 1)
                v++
            pow9 /= 9
            res += v * pow9

        }
        return res
    }
}

fun main() {
    val solution = Solution3747()
    check(solution.countDistinct(10L) == 9L) {"test1"}
    check(solution.countDistinct(3L) == 3L) {"test1"}
}
