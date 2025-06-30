package com.leetcode.solution.math

class Solution2566 {
    fun minMaxDifference(num: Int): Int {
        val s = num.toString()
        val firstMax = s.firstOrNull { it != '9'}
        val mx = firstMax?.let { s.replace(it, '9') } ?: s
        val firstMin = s.first()
        val mi = s.replace(firstMin, '0')
        return mx.toInt() - mi.toInt()
    }

    fun minMaxDifference1(num: Int): Int {
        var mx = 0
        var mi = 0
        var maxRemapDigit = -1
        var minRemapDigit = -1
        for ((i, x) in num.toString().withIndex()) {
            val cur = x.digitToInt()
            if (i == 0) {
                minRemapDigit = cur
            }
            if (cur != 9 && maxRemapDigit == -1) {
                maxRemapDigit = cur
            }

            mx = mx * 10 + (if (maxRemapDigit == cur) 9 else cur)
            mi = mi * 10 + (if (minRemapDigit == cur) 0 else cur)
        }

        return mx - mi
    }
}

fun main() {
    val solution = Solution2566()
    check(solution.minMaxDifference(11891) == 99009) {"wrong result"}
    check(solution.minMaxDifference(90) == 99) {"wrong result"}
}
