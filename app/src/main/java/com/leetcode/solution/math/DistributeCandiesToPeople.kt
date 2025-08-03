package com.leetcode.solution.math

import kotlin.math.sqrt

class Solution1103 {
    fun distributeCandies(candies: Int, num_people: Int): IntArray {
        var res = IntArray(num_people)
        var x = (sqrt((2 * candies).toDouble() + 0.25) - 0.5).toInt()
        for (i in 1..num_people) {
            val m = x / num_people + (if (x % num_people >= i) 1 else 0)
            res[i - 1] = m * i + m * (m - 1) / 2 * num_people
        }
        res[x % num_people] += candies - x * (x + 1) / 2
        return res
    }
}

fun main() {
    val solution = Solution1103()
    check(solution.distributeCandies(7, 4).contentEquals(intArrayOf(1,2,3,1))) {"wrong result"}
    check(solution.distributeCandies(10, 3).contentEquals(intArrayOf(5,2,3))) {"wrong result"}
}
