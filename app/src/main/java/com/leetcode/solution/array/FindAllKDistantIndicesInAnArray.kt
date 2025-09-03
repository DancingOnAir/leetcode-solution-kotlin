package com.leetcode.solution.array

import kotlin.math.max
import kotlin.math.min

class Solution2200 {
    fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
        val res = mutableListOf<Int>()
        var right = 0
        for ((i, x) in nums.withIndex()) {
            if (x == key) {
                val left = max(i - k, right)
                right = min(i+k+1, nums.size)
                for (j in left until right) {
                    res.add(j)
                }
            }
        }
        return res
    }

    fun findKDistantIndices1(nums: IntArray, key: Int, k: Int): List<Int> {
        val res = mutableSetOf<Int>()
        for ((i, x) in nums.withIndex()) {
            if (x == key) {
                for (j in max(0,i-k)..min(i+k,nums.size-1)) {
                    res.add(j)
                }
            }
        }
        return res.toList()
    }
}

fun main() {
    val solution = Solution2200()
    check(solution.findKDistantIndices(intArrayOf(3,4,9,1,3,9,5),9,1) == listOf<Int>(1,2,3,4,5,6)) {"testing1 wrong result"}
    check(solution.findKDistantIndices(intArrayOf(2,2,2,2,2),2,2) == listOf<Int>(0,1,2,3,4)) {"testing2 wrong result"}
}
