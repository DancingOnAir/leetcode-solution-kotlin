package com.leetcode.solution.unionFind

class Solution3551 {
    fun minSwaps(nums: IntArray): Int {
        val a = nums.toMutableList()
        val idx = nums.mapIndexed { id, x -> x to id }.toMap().toMutableMap()

        fun digitSum(num: Int) = num.toString().sumOf { it.digitToInt() }
        val sortedNums = nums.sortedWith(compareBy({ digitSum(it) }, { it }))

        var res = 0
        for ((i, x) in sortedNums.withIndex()) {
            val j = idx[x]!!
            if (i == j)
                continue

            val temp = a[i]
            a[i] = a[j]
            a[j] = temp

            idx[x] = i
            idx[temp] = j
            res++
        }
        return res
    }
}

fun main() {
    val solution = Solution3551()
    check(solution.minSwaps(intArrayOf(37,100)) == 1) {"test1 wrong result"}
    check(solution.minSwaps(intArrayOf(22,14,33,7)) == 0) {"test2 wrong result"}
    check(solution.minSwaps(intArrayOf(18,43,34,16)) == 2) {"test3 wrong result"}
}
