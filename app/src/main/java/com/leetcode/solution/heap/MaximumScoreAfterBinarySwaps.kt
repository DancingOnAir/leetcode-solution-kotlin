package com.leetcode.solution.heap

import java.util.PriorityQueue

class Solution3781 {
    fun maximumScore(nums: IntArray, s: String): Long {
        val pq = PriorityQueue<Int>()
        var res = 0L
        for ((i, c) in nums.withIndex()) {
            pq.add(-c)
            if (s[i] == '1') {
                res += -pq.poll()!!
            }
        }

        return res
    }
}

fun main() {
    val solution = Solution3781()
    check(solution.maximumScore(intArrayOf(2,1,5,2,3), "01010") == 7L) {"test1"}
    check(solution.maximumScore(intArrayOf(4,7,2,9), "0000") == 0L) {"test2"}
}
