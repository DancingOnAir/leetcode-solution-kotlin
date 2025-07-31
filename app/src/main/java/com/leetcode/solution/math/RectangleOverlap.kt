package com.leetcode.solution.math

class Solution0836 {
    fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
        return !(rec1[0] >= rec2[2] || rec1[2] <= rec2[0] || rec1[1] >= rec2[3] || rec1[3] <= rec2[1])
    }
}

fun main() {
    val solution = Solution0836()
    check(solution.isRectangleOverlap(intArrayOf(0,0,2,2), intArrayOf(1,1,3,3))) {"test1 wrong result"}
    check(!solution.isRectangleOverlap(intArrayOf(0,0,1,1), intArrayOf(1,0,2,1))) {"test2 wrong result"}
    check(!solution.isRectangleOverlap(intArrayOf(0,0,1,1), intArrayOf(2,2,3,3))) {"test3 wrong result"}
}
