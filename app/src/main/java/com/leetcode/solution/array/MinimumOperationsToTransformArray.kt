package com.leetcode.solution.array

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Solution3724 {
    // https://leetcode.cn/problems/minimum-operations-to-transform-array/solutions/3815528/tan-xin-fen-lei-tao-lun-pythonjavacgo-by-yvxx/
    fun minOperations(nums1: IntArray, nums2: IntArray): Long {
        val target = nums2.last()
        var res = 1L
        var mn = Int.MAX_VALUE
        for ((a, b) in nums1.zip(nums2)) {
            val (x, y) = if (a > b) b to a else a to b
            res += y - x
            if (mn > 0)
                mn = min(mn, max(x - target, target - y))
        }
        return res + max(mn, 0)
    }

    fun minOperations1(nums1: IntArray, nums2: IntArray): Long {
        var mi = Int.MAX_VALUE

        fun helper(a: Int, b: Int) {
            if (nums2.last() < a) {
                mi = min(mi, a - nums2.last())
            }
            else if (nums2.last() > b) {
                mi = min(mi, nums2.last() - b)
            } else {
                mi = 0
            }
        }

        var res = 0L

        for (i in 0..nums1.lastIndex) {
            if (nums1[i] > nums2[i])
                helper(nums2[i], nums1[i])
            else {
                helper(nums1[i], nums2[i])
            }

            res += abs(nums2[i] - nums1[i])
        }
        return res + mi + 1
    }
}

fun main() {
    val solution = Solution3724()
    check(solution.minOperations(intArrayOf(2,8), intArrayOf(1,7,3)) == 4L) {"test1 wrong result"}
    check(solution.minOperations(intArrayOf(1,3,6), intArrayOf(2,4,5,3)) == 4L) {"test2 wrong result"}
    check(solution.minOperations(intArrayOf(2), intArrayOf(3,4)) == 3L) {"test3 wrong result"}
}
