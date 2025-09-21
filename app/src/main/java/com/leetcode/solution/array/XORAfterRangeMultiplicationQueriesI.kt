package com.leetcode.solution.array

class Solution3653 {
    fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
        for ((l, r, k, v) in queries) {
            for (i in l..r step k) {
                nums[i] = ((nums[i].toLong() * v) % (1e9 + 7)).toInt()
            }
        }
        return nums.reduce { acc, x -> acc xor x }
    }
}

fun main() {
    val solution = Solution3653()
    check(solution.xorAfterQueries(intArrayOf(1,1,1), arrayOf(intArrayOf(0,2,1,4))) == 4) {"test1 wrong result"}
    check(solution.xorAfterQueries(intArrayOf(2,3,1,5,4), arrayOf(intArrayOf(1,4,2,3), intArrayOf(0,2,1,2))) == 31) {"test2 wrong result"}
}
