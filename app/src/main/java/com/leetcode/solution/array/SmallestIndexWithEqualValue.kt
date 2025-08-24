package com.leetcode.solution.array

class Solution2057 {
    fun smallestEqual(nums: IntArray): Int {
        return nums.withIndex().indexOfFirst { (i,x) -> i % 10 == x }
    }
}

fun main() {
    val solution = Solution2057()
    check(solution.smallestEqual(intArrayOf(0,1,2)) == 0) {"testing1 wrong result"}
    check(solution.smallestEqual(intArrayOf(4,3,2,1)) == 2) {"testing2 wrong result"}
    check(solution.smallestEqual(intArrayOf(1,2,3,4,5,6,7,8,9,0)) == -1) {"testing3 wrong result"}
}
