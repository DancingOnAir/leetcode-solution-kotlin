package com.leetcode.solution.array

class Solution2824 {
    fun countPairs(nums: List<Int>, target: Int) = nums.indices.sumOf { i -> (i+1 until nums.size).count { j -> nums[i] + nums[j] < target } }


    fun countPairs1(nums: List<Int>, target: Int): Int {
        var res = 0
        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                if (nums[i] + nums[j] < target)
                    ++res
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution2824()
    check(solution.countPairs(listOf(-1,1,2,3,1), 2) == 3) {"testing1 wrong result"}
    check(solution.countPairs(listOf(-6,2,5,-2,-7,-1,3), -2) == 10) {"testing2 wrong result"}
}
