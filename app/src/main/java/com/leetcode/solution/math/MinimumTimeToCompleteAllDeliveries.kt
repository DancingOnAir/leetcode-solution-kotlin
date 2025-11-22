package com.leetcode.solution.math

import kotlin.math.max

class Solution3733 {
    fun minimumTime(d: IntArray, r: IntArray): Long {
        val (d1, d2) = d
        val (r1, r2) = r

        fun gcd(a: Int, b: Int): Int {
            return if (b == 0) a else gcd(b, a % b)
        }

        fun lcm(a: Int, b: Int): Int {
            return if (a == 0 || b == 0) 0 else a / gcd(a, b) * b
        }

        fun helper(d: Int, r: Int): Long {
            return 1L * d + (d - 1) / (r - 1)
        }

        val l = lcm(r1, r2)
        return maxOf(helper((d1 + d2), l), helper(d1, r1), helper(d2, r2))
    }
}

fun main() {
    val solution = Solution3733()
    check(solution.minimumTime(intArrayOf(1000000000,1000000000), intArrayOf(2,2)) == 3999999999L) {"test4"}
    check(solution.minimumTime(intArrayOf(3,1), intArrayOf(2,3)) == 5L) {"test1"}
    check(solution.minimumTime(intArrayOf(1,3), intArrayOf(2,2)) == 7L) {"test2"}
    check(solution.minimumTime(intArrayOf(2,1), intArrayOf(3,4)) == 3L) {"test3"}
}
