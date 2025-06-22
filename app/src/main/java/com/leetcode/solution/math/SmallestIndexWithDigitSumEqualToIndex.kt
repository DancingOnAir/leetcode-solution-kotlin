package com.leetcode.solution.math

class SolutionQ3550 {
    fun smallestIndex(nums: IntArray): Int {
        fun digitalSum(n: Int) = generateSequence(n) { it / 10 }.takeWhile { it > 0 }.sumBy { it % 10 }
        return nums.withIndex().indexOfFirst { (i, x) -> i == digitalSum(x) }
    }

    fun smallestIndex1(nums: IntArray): Int {
        for ((i, x) in nums.withIndex()) {
            var tot = 0
            var cur = x
            while (cur > 0) {
                tot += (cur % 10)
                cur /= 10
            }

            if (i == tot)
                return i
        }
        return -1
    }
}

fun main() {
    val solution = SolutionQ3550()
    check(solution.smallestIndex(intArrayOf(1, 3, 2)) == 2) {"wrong result"}
    check(solution.smallestIndex(intArrayOf(1, 10, 11)) == 1) {"wrong result"}
    check(solution.smallestIndex(intArrayOf(1, 2, 3)) == -1) {"wrong result"}
}
