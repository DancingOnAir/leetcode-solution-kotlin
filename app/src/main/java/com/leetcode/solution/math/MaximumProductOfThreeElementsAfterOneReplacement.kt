package com.leetcode.solution.math

import java.util.PriorityQueue
import kotlin.math.abs

class Solution3732 {
    fun maxProduct(nums: IntArray): Long {
        val minHeap = PriorityQueue<Int>()
        for (x in nums) {
            minHeap.add(abs(x))
            if (minHeap.size == 4) {
                minHeap.poll()
            }
        }

        minHeap.poll()
        var tot = 1L
        while (minHeap.isNotEmpty()) {
            val cur = minHeap.poll()
            if (cur == 0) {
                return 0
            }
            tot *= cur!!
        }

        return tot * 1e5.toLong()
    }
}

fun main() {
    val solution = Solution3732()
    check(solution.maxProduct(intArrayOf(-5,7,0)) == 3500000L) {"test1 wrong result"}
    check(solution.maxProduct(intArrayOf(-4,-2,-1,-3)) == 1200000L) {"test2 wrong result"}
    check(solution.maxProduct(intArrayOf(0,10,0)) == 0L) {"test3 wrong result"}
}
