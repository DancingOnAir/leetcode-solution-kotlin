package com.leetcode.solution.array

class Solution2656 {
    fun maximizeSum(nums: IntArray, k: Int): Int {
        return nums.max() * k + (k - 1) * k / 2
    }
}

fun main() {
    val solution = Solution2656()
    check(solution.maximizeSum(intArrayOf(1,2,3,4,5),3) == 18) {"testing1 wrong result"}
    check(solution.maximizeSum(intArrayOf(5,5,5),2) == 11) {"testing2 wrong result"}
}
