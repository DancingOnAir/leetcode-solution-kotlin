package com.leetcode.solution.math

import com.leetcode.solution.array.Solution2670
import kotlin.math.sqrt

class Solution2614 {
    fun diagonalPrime(nums: Array<IntArray>): Int {
        fun Int.isPrime(): Boolean {
            return when {
                this == 2 || this == 3 -> return true
                this <= 1 || this % 2 == 0 || this % 3 == 0 -> return false
                else -> {
                    val root = sqrt(this.toDouble()).toInt()
                    for (x in 5..root step 6) {
                        if (this % x == 0 || this % (x + 2) == 0)
                            return false
                    }
                    return true
                }
            }
        }

        var res = 0
        for (i in 0 until nums.size) {
            if (nums[i][i] > res && nums[i][i].isPrime())
                res = nums[i][i]
            if (nums[i][nums.size - i - 1] > res && nums[i][nums.size - i - 1].isPrime())
                res = nums[i][nums.size - i - 1]
        }
        return res
    }
}

fun main() {
    val solution = Solution2614()
    check(solution.diagonalPrime(arrayOf(intArrayOf(1,2,3), intArrayOf(5,6,7), intArrayOf(9,10,11))) == 11) {"testing1 wrong result"}
    check(solution.diagonalPrime(arrayOf(intArrayOf(1,2,3), intArrayOf(5,17,7), intArrayOf(9,11,10))) == 17) {"testing2 wrong result"}
}
