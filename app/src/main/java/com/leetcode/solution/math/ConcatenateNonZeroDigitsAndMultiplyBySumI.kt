package com.leetcode.solution.math

class Solution3754 {
    fun sumAndMultiply(n: Int): Long {
        var s = 0L
        var num = 0L
        var pow10 = 1L
        var n = n
        while (n > 0) {
            val r = n % 10
            n /= 10
            if (r == 0)
                continue
            s += r * pow10
            pow10 *= 10
            num += r
        }
        return s * num
    }

    fun sumAndMultiply1(n: Int): Long {
        var s = ""
        var tot = 0L
        for (c in n.toString()) {
            if (c == '0')
                continue
            tot += c.digitToInt()
            s += c
        }
        return tot * s.toLong()
    }
}

fun main() {
    val solution = Solution3754()
    check(solution.sumAndMultiply(10203004) == 12340L)
    check(solution.sumAndMultiply(1000) == 1L)
}
