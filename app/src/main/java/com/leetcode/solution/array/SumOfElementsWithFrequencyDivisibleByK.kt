package com.leetcode.solution.array

class Solution3712 {
    fun sumDivisibleByK(nums: IntArray, k: Int): Int {
        val cnt = nums.toList().groupingBy { it }.eachCount()
        return cnt.entries.sumOf { (a, b) -> if (b % k == 0) a * b else 0 }
    }

    fun sumDivisibleByK1(nums: IntArray, k: Int): Int {
        val cnt = mutableMapOf<Int, Int>()
        for (x in nums) {
            cnt[x] = cnt.getOrDefault(x, 0) + 1
        }
        var res = 0
        for ((x, v) in cnt) {
            if (v % k == 0)
                res += x * v
        }
        return res
    }
}

fun main() {
    val solution = Solution3712()
    check(solution.sumDivisibleByK(intArrayOf(1,2,2,3,3,3,3,4), 2) == 16) {"test1 wrong result"}
    check(solution.sumDivisibleByK(intArrayOf(1,2,3,4,5), 2) == 0) {"test2 wrong result"}
    check(solution.sumDivisibleByK(intArrayOf(4,4,4,1,2,3), 3) == 12) {"test3 wrong result"}
}
