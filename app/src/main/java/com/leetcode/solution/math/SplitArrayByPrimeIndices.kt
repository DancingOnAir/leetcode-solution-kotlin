package com.leetcode.solution.math

import kotlin.math.abs
import kotlin.math.sqrt

class Solution3618 {
    fun splitArray(nums: IntArray): Long {
        fun Int.isPrimes(): Boolean {
            return when {
                this == 2 || this == 3 -> true
                this <= 1 || this % 2 == 0 || this % 3 == 0 -> false
                else -> {
                    val root = sqrt(this.toDouble()).toInt()
                    for (i in 5..root step 6) {
                        if (this % i == 0 || this % (i + 2) == 0)
                            return false
                    }
                    return true
                }
            }
        }

        var sumA = 0L
        var sumB = 0L
        for ((i, x) in nums.withIndex()) {
            if (i.isPrimes()) {
                sumA += x
            }
            else {
                sumB += x
            }
        }
        return abs(sumA - sumB)
    }
}

fun main() {
    val solution = Solution3618()
    check(solution.splitArray(intArrayOf(2,3,4)) == 1L) {"test1"}
    check(solution.splitArray(intArrayOf(-1,5,7,0)) == 3L) {"test2"}
}
