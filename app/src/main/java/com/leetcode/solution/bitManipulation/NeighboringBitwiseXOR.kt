package com.leetcode.solution.bitManipulation

class Solution2683 {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        return derived.fold(0, Int::xor) == 0
    }

    fun doesValidArrayExist1(derived: IntArray): Boolean {
        var x = 0
        val res = mutableListOf<Int>()
        for (i in derived.lastIndex downTo 0) {
            val cur = x xor derived[i]
            res.add(cur)
            x = cur
        }
        return (res.first() xor res.last()) == derived.last()
    }
}

fun main() {
    val solution = Solution2683()
    check(solution.doesValidArrayExist(intArrayOf(1,1,0))) {"test1 wrong result"}
    check(solution.doesValidArrayExist(intArrayOf(1,1))) {"test2 wrong result"}
    check(!solution.doesValidArrayExist(intArrayOf(1,0))) {"test3 wrong result"}
}

