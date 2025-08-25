package com.leetcode.solution.array

import kotlin.math.abs

class Solution2006 {
    fun countKDifference(nums: IntArray, k: Int): Int {
        val m = mutableMapOf<Int, Int>()
        var res = 0
        for (x in nums) {
            m[x] = m.getOrDefault(x,0) + 1
            res += m.getOrDefault(x - k,0) + m.getOrDefault(x + k,0)
        }
        return res
    }

    fun countKDifference1(nums: IntArray, k: Int): Int {
        var res = 0
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (abs(nums[i] - nums[j]) == k)
                    res++
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution2006()
    check(solution.countKDifference(intArrayOf(1,2,2,1),1) == 4) {"testing1 wrong result"}
    check(solution.countKDifference(intArrayOf(1,3),3) == 0) {"testing2 wrong result"}
    check(solution.countKDifference(intArrayOf(3,2,1,5,4),2) == 3) {"testing3 wrong result"}
}
