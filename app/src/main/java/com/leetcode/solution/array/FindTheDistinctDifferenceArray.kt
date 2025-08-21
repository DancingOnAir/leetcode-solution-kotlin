package com.leetcode.solution.array

class Solution2670 {
    fun distinctDifferenceArray(nums: IntArray): IntArray {
        val pre = mutableMapOf<Int, Int>()
        val suf = mutableMapOf<Int, Int>()
        val res = IntArray(nums.size)
        nums.forEach { suf[it] = suf.getOrDefault(it,0) + 1 }
        nums.forEachIndexed { i, x ->
            pre[x] = pre.getOrDefault(x,0) + 1
            suf[x] = suf.getOrDefault(x,0) - 1
            if (suf[x] == 0)
                suf.remove(x)
            res[i] = pre.size - suf.size
        }
        return res
    }

    // original
    fun distinctDifferenceArray1(nums: IntArray): IntArray {
        var m = mutableMapOf<Int, Int>()
        for (x in nums) {
            m[x] = m.getOrDefault(x,0) + 1
        }

        var pre = mutableMapOf<Int, Int>()
        var res = mutableListOf<Int>()
        for (x in nums) {
            m[x] = m.getOrDefault(x,0) - 1
            if (m[x] == 0) {
                m.remove(x)
            }

            pre[x] = pre.getOrDefault(x,0) + 1
            res.add(pre.size - m.size)

        }
        return res.toIntArray()
    }
}

fun main() {
    val solution = Solution2670()
    check(solution.distinctDifferenceArray(intArrayOf(1,2,3,4,5)).contentEquals(intArrayOf(-3,-1,1,3,5))) {"testing1 wrong result"}
    check(solution.distinctDifferenceArray(intArrayOf(3,2,3,4,2)).contentEquals(intArrayOf(-2,-1,0,2,3))) {"testing2 wrong result"}
}
