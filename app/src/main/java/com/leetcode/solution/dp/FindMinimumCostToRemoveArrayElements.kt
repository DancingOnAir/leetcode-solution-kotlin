package com.leetcode.solution.dp

import kotlin.math.max
import kotlin.math.min

class Solution3469 {
    fun minCost(nums: IntArray): Int {
        val n = nums.size
        val m = mutableMapOf<Pair<Int, Int>, Int>()
        fun dfs(i: Int, j: Int): Int {
            if (i == n)
                return nums[j]
            if (i == n - 1)
                return max(nums[i], nums[j])

            val k = i to j
            if (m.contains(k))
                return m[k]!!

            val a = nums[j]
            val b = nums[i]
            val c = nums[i + 1]
            val res = min(dfs(i + 2, j) + max(b, c), min(dfs(i + 2, i) + max(a, c), dfs(i + 2, i + 1) + max(a, b)))
            m[k] = res
            return res
        }

        val res = dfs(1,0)
        m.clear()
        return res
    }
}

fun main() {
    val solution = Solution3469()
    check(solution.minCost(intArrayOf(6,2,8,4)) == 12) {"test1 wrong result"}
    check(solution.minCost(intArrayOf(2,1,3,3)) == 5) {"test2 wrong result"}
}
