package com.leetcode.solution.array

import kotlin.math.abs

class Solution2037 {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        return seats.sorted().zip(students.sorted()) { a, b -> abs(a - b) }.sum()
    }

    fun minMovesToSeat1(seats: IntArray, students: IntArray): Int {
        seats.sort()
        students.sort()
        var res = 0
        for (i in 0 until seats.size) {
            res += abs(seats[i] - students[i])
        }
        return res
    }
}

fun main() {
    val solution = Solution2037()
    check(solution.minMovesToSeat(intArrayOf(3,1,5), intArrayOf(2,7,4)) == 4) {"test1 wrong result"}
    check(solution.minMovesToSeat(intArrayOf(4,1,5,9), intArrayOf(1,3,2,6)) == 7) {"test2 wrong result"}
}
