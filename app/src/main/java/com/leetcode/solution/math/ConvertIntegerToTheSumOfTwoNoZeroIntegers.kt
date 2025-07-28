package com.leetcode.solution.math

class Solution1317 {
    fun getNoZeroIntegers(n: Int): IntArray {
        (1 .. n).forEach{
            if (!it.toString().contains('0') && !(n - it).toString().contains('0')) {
                return intArrayOf(it, n - it)
            }
        }
        return intArrayOf()
    }

    fun getNoZeroIntegers1(n: Int): IntArray {
        for (i in 1 .. n) {
            if (!i.toString().contains('0') && !(n - i).toString().contains('0')) {
                return intArrayOf(i, n - i)
            }
        }
        return intArrayOf()
    }
}

fun main() {
    val solution = Solution1317()
    check(solution.getNoZeroIntegers(2).contentEquals(intArrayOf(1, 1))) { "wrong result" }
    check(solution.getNoZeroIntegers(11).contentEquals(intArrayOf(2, 9))) { "wrong result" }
}
