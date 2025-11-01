package com.leetcode.solution.bitManipulation

class Solution3007 {
    // https://leetcode.com/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k/solutions/4566407/python-3-7-lines-bin-search-t-s-88-92/?envType=problem-list-v2&envId=bit-manipulation
    fun findMaximumNumber(k: Long, x: Int): Long {
        fun check(num: Long): Boolean {
            var tot = 0L
            for (i in 1..62) {
                if (i % x == 0) {
                    val e = 1L shl i
                    tot += (num / e) * (e / 2)
                    tot += maxOf(0, (num % e) + 1 - (e / 2))
                }
            }
            return tot <= k
        }

        var left = 1L
        var right = (k + 1).shl(x)
        var res = -1L
        while (left <= right) {
            val mid = (left + right) / 2
            if (check(mid)) {
                res = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return res
    }

    // TLE
    fun findMaximumNumber1(k: Long, x: Int): Long {
        fun helper(num: Long): Int {
            val mask = ("1" + "0".repeat(x - 1)).repeat(Int.SIZE_BITS / x)
            return (mask.toLong(2) and num).countOneBits()
        }

        var i = 0L
        var tot = 0L
        while (tot <= k) {
            tot += helper(++i)
        }
        return i - 1
    }
}

fun main() {
    val solution = Solution3007()
//    check(solution.findMaximumNumber(9L,1) == 6L) {"test1 wrong result"}
    check(solution.findMaximumNumber(7L,2) == 9L) {"test2 wrong result"}
}
