package com.leetcode.solution.array

class Solution2164 {
    fun sortEvenOdd(nums: IntArray): IntArray {
        var even = nums.filterIndexed { i, _ -> i % 2 == 0 }.sorted()
        var odd = nums.filterIndexed { i, _ -> i % 2 == 1 }.sortedDescending()
        for (i in nums.indices) {
            nums[i] = if (i % 2 == 0) even[i/2] else odd[i/2]
        }
        return nums
    }

    fun sortEvenOdd1(nums: IntArray): IntArray {
        val even = mutableListOf<Int>()
        val odd = mutableListOf<Int>()
        for ((i, x) in nums.withIndex()) {
            if (i % 2 == 0)
                even.add(x)
            else
                odd.add(x)
        }

        even.sort()
        odd.sortDescending()
        val res = mutableListOf<Int>()
        for (i in 0 until nums.size) {
            if (i % 2 == 0)
                res.add(even[i/2])
            else
                res.add(odd[i/2])
        }
        return res.toIntArray()
    }
}

fun main() {
    val solution = Solution2164()
    check(solution.sortEvenOdd(intArrayOf(4,1,2,3)).contentEquals(intArrayOf(2,3,4,1))) {"testing1 wrong result"}
    check(solution.sortEvenOdd(intArrayOf(2,1)).contentEquals(intArrayOf(2,1))) {"testing2 wrong result"}
}
