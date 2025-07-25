package com.leetcode.solution.math

class Solution1323 {
    fun maximum69Number (num: Int): Int {
        return num.toString().replaceFirst('6', '9').toInt()
    }
}

fun main() {
    val solution = Solution1323()
    check(solution.maximum69Number(9669) == 9969) { "wrong result" }
    check(solution.maximum69Number(9996) == 9999) { "wrong result" }
    check(solution.maximum69Number(9999) == 9999) { "wrong result" }
}

