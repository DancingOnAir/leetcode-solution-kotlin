package com.leetcode.solution.array

class Solution2848 {
    fun numberOfPoints(nums: List<List<Int>>): Int {
        return nums.flatMap { it.first()..it.last() }.toSet().size
    }

    fun numberOfPoints1(nums: List<List<Int>>): Int {
        val sorted = nums.sortedBy { it.first() }

        var res = 0
        var cur = 0
        for (r in sorted) {
            if (cur <= r.first()) {
                res += r.last() - r.first() + 1
                cur = r.last() + 1
            } else if (cur <= r.last()) {
                res += r.last() - cur + 1
                cur = r.last() + 1
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution2848()
    check(solution.numberOfPoints(listOf(listOf(3,6), listOf(1,5), listOf(4,7))) == 7) {"testing1 wrong result"}
    check(solution.numberOfPoints(listOf(listOf(1,3), listOf(5,8))) == 7) {"testing2 wrong result"}
}
