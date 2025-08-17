package com.leetcode.solution.array

import kotlin.math.max
import kotlin.math.min

class Solution2293 {
    fun minMaxGame(nums: IntArray): Int {
        var n = nums.size
        while (n > 1) {
            n /= 2
            for (i in 0 until n) {
                if (i % 2 == 0) {
                    nums[i] = min(nums[i*2], nums[i*2+1])
                } else {
                    nums[i] = max(nums[i*2], nums[i*2+1])
                }
            }
        }
        return nums.first()
    }
}

fun main() {
    val solution = Solution2293()
    check(solution.minMaxGame(intArrayOf(1,3,5,2,4,8,2,2)) == 1) {"testing1 wrong result"}
    check(solution.minMaxGame(intArrayOf(3)) == 3) {"testing2 wrong result"}
}
