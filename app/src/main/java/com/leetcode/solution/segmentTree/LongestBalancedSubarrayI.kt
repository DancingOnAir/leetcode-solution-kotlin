package com.leetcode.solution.segmentTree

class Solution3719 {
    fun longestBalanced(nums: IntArray): Int {
        var res = 0
        return res
//        val n = nums.size
//        var oddCnt = 0
//        var evenCnt = 0
//        val oddPs = IntArray(n + 1)
//        val evenPs = IntArray(n + 1)
//        for ((i, x) in nums.withIndex()) {
//            if (x % 2 == 0) {
//                evenCnt++
//                evenPs[i + 1] = evenCnt
//            } else {
//                oddCnt++
//                oddPs[i + 1] = oddCnt
//            }
//        }
//
//        var res = 0
//        for (i in 0 until n) {
//            for (j in i + 1..n) {
//                if (evenPs[j] - evenPs[i] == oddPs[j] - oddPs[i]) {
//                   res = max(res, j - i)
//                }
//            }
//        }
//        return res
    }
}

fun main() {
    val solution = Solution3719()
    check(solution.longestBalanced(intArrayOf(2,5,4,3)) == 4) {"test1 wrong result"}
    check(solution.longestBalanced(intArrayOf(3,2,2,5,4)) == 5) {"test2 wrong result"}
    check(solution.longestBalanced(intArrayOf(1,2,3,2)) == 3) {"test3 wrong result"}
}
