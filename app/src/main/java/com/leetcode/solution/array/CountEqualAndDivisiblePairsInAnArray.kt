package com.leetcode.solution.array

class Solution2176 {
    fun countPairs(nums: IntArray, k: Int): Int {
        var res = 0
        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    ++res
                }
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution2176()
    check(solution.countPairs(intArrayOf(3,1,2,2,2,1,3), 2) == 4) {"test1 wrong result"}
    check(solution.countPairs(intArrayOf(1,2,3,4), 1) == 0) {"test1 wrong result"}
}
