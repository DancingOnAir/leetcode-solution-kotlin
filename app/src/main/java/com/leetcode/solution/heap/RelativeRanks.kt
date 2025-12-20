package com.leetcode.solution.heap

import java.util.PriorityQueue

class Solution0506 {
    fun findRelativeRanks(score: IntArray): Array<String> {
        val desc = arrayOf("Gold Medal", "Silver Medal", "Bronze Medal")
        val res = Array(score.size) {""}
        val sortedScore = score.withIndex().sortedByDescending { it.value }
        for ((i, s) in sortedScore.withIndex()) {
            val originIdx = s.index
            if (i < 3)
                res[originIdx] = desc[i]
            else
                res[originIdx] = (i + 1).toString()
        }
        return res
    }
}

fun main() {
    val solution = Solution0506()
    check(solution.findRelativeRanks(intArrayOf(5,4,3,2,1)).contentEquals(arrayOf("Gold Medal","Silver Medal","Bronze Medal","4","5"))) {"test1"}
    check(solution.findRelativeRanks(intArrayOf(10,3,8,9,4)).contentEquals(arrayOf("Gold Medal","5","Bronze Medal","Silver Medal","4"))) {"test2"}
}
