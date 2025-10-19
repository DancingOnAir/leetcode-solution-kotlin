package com.leetcode.solution.hashmap

class Solution2682 {
    fun circularGameLosers(n: Int, k: Int): IntArray {
        val vis = BooleanArray(n)
        var i = 0
        var d = k
        while (!vis[i]) {
            vis[i] = true
            i = (i + d) % n
            d += k
        }
        return vis.withIndex().filterNot { it.value }.map { it.index + 1}.toIntArray()
    }

    fun circularGameLosers1(n: Int, k: Int): IntArray {
        val vis = IntArray(n) {0}
        var i = 0
        var d = k
        while (vis[i] == 0) {
            vis[i] = 1
            i = (i + d) % n
            d += k
        }

        val res = mutableListOf<Int>()
        for (i in 0 until n) {
            if (vis[i] == 0)
                res.add(i + 1)
        }
        return res.toIntArray()
    }
}

fun main() {
    val solution = Solution2682()
    check(solution.circularGameLosers(5, 2).contentEquals(intArrayOf(4,5))) {"test1 wrong result"}
    check(solution.circularGameLosers(4, 4).contentEquals(intArrayOf(2,3,4))) {"test2 wrong result"}
}
