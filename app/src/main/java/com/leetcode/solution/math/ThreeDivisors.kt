package com.leetcode.solution.math

import kotlin.math.sqrt

class Solution1952 {
    fun isThree(n: Int): Boolean {
        fun Int.isPrime(): Boolean {
            return when {
                this == 2 || this == 3 -> true
                this <= 1 || this % 2 == 0 || this % 3 == 0 -> return false
                else -> {
                    val root = sqrt(this.toDouble()).toInt()
                    for (x in 5 .. root step 6) {
                        if (this % x == 0 || this % (x + 2) == 0)
                            return false
                    }
                    return true
                }
            }
        }
        val x = sqrt(n.toDouble()).toInt()
        return n == x * x && x.isPrime()
    }
}

fun main() {
    val solution = Solution1952()
    check(!solution.isThree(2)) { "wrong result" }
    check(solution.isThree(4)) { "wrong result" }
}
