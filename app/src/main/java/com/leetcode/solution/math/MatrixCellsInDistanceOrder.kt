package com.leetcode.solution.math

import kotlin.math.abs

class Solution1030 {
    fun allCellsDistOrder(rows: Int, cols: Int, rCenter: Int, cCenter: Int): Array<IntArray> {
        fun dist(x: Int, y: Int) = abs(x - rCenter) + abs(y - cCenter)

        val res = mutableListOf<IntArray>()
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                res.add(intArrayOf(i, j))
            }
        }

        return res.sortedBy{dist(it[0], it[1])}.toTypedArray()
    }
}

fun main() {
    val solution = Solution1030()
    check(solution.allCellsDistOrder(1, 2, 0, 0).contentEquals(arrayOf(intArrayOf(0,0), intArrayOf(0,1))))
    check(solution.allCellsDistOrder(2, 2, 0, 1).contentEquals(arrayOf(intArrayOf(0,1), intArrayOf(0,0), intArrayOf(1,1), intArrayOf(1,0))))
    check(solution.allCellsDistOrder(2, 3, 1, 2).contentEquals(arrayOf(intArrayOf(1,2), intArrayOf(0,2), intArrayOf(1,1), intArrayOf(0,1), intArrayOf(1,0), intArrayOf(0,0))))
}