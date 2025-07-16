package com.leetcode.solution.math

class Solution1979 {
    fun findGCD(nums: IntArray): Int {
        fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

        return gcd(nums.min(), nums.max())
    }
}

fun main() {
    val solution = Solution1979()
    check(solution.findGCD(intArrayOf(2,5,6,9,10)) == 2) { "wrong result" }
    check(solution.findGCD(intArrayOf(7,5,6,8,3)) == 1) { "wrong result" }
    check(solution.findGCD(intArrayOf(3,3)) == 3) { "wrong result" }
}
