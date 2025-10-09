package com.leetcode.solution.array

class Solution3668 {
    fun recoverOrder(order: IntArray, friends: IntArray): IntArray {
        return order.filter { it in friends.toSet() }.toIntArray()
    }

    fun recoverOrder1(order: IntArray, friends: IntArray): IntArray {
        val m = mutableMapOf<Int, Int>()
        for ((i, x) in order.withIndex()) {
            m[x] = i
        }
        return friends.sortedBy { m[it] }.toIntArray()
    }
}

fun main() {
    val solution = Solution3668()
    check(solution.recoverOrder(intArrayOf(3,1,2,5,4), intArrayOf(1,3,4))
        .contentEquals(intArrayOf(3,1,4))) {"test1 wrong result"}
    check(solution.recoverOrder(intArrayOf(1,4,5,3,2), intArrayOf(2,5))
        .contentEquals(intArrayOf(5,2))) {"test2 wrong result"}
}
