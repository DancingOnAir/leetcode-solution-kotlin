package com.leetcode.solution.hashtable

class Solution3761 {
    fun minMirrorPairDistance(nums: IntArray): Int {
        var res = Int.MAX_VALUE
        val m = mutableMapOf<Int, Int>()
        for ((i, x) in nums.withIndex()) {
            if (x in m) {
                res = minOf(res, i - m[x]!!)
            }

            val cur = x.toString().reversed().toInt()
            m[cur] = i
        }
        return if (res != Int.MAX_VALUE) res else -1
    }
}

fun main() {
    val solution = Solution3761()
    check(solution.minMirrorPairDistance(intArrayOf(12,21,45,33,54)) == 1) {"test1"}
    check(solution.minMirrorPairDistance(intArrayOf(120,21)) == 1) {"test2"}
    check(solution.minMirrorPairDistance(intArrayOf(21,120)) == -1) {"test3"}
}
