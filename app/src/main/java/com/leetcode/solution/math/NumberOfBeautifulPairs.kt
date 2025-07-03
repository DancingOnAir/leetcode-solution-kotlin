package com.leetcode.solution.math

class Solution2748 {
    fun gcd (a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }

    fun countBeautifulPairs(nums: IntArray): Int {
        var res = 0
        for (i in 0 .. nums.size - 2) {
            for (j in i + 1 ..< nums.size) {
                if (gcd(nums[i].toString().first().code - 48, nums[j] % 10) == 1) {
                    res += 1
                }
            }
        }
        return res
    }

    fun countBeautifulPairs1(nums: IntArray): Int {
        var res = 0
        for (i in 0 .. nums.size - 2) {
            for (j in i + 1 .. nums.size - 1) {
                if (gcd(nums[i].toString().first().digitToInt(), nums[j].toString().last().digitToInt()) == 1) {
                    res += 1
                }
            }
        }

        return res
    }
}

fun main() {
    val solution = Solution2748()
    check(solution.countBeautifulPairs(intArrayOf(2, 5, 1, 4)) == 5) { "wrong result" }
    check(solution.countBeautifulPairs(intArrayOf(11, 21, 12)) == 2) { "wrong result" }
}
