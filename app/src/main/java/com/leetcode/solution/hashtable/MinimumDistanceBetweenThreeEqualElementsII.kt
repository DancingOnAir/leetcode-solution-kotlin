package com.leetcode.solution.hashtable

import kotlin.math.min

class Solution3741 {
    fun minimumDistance(nums: IntArray): Int {
        val cnt = mutableMapOf<Int, MutableList<Int>>()
        for ((i, x) in nums.withIndex()) {
            if (i >= 2 && x == nums[i - 1] && x == nums[i - 2])
                return 4
            if (cnt.contains(x)) {
                cnt[x]!!.add(i)
            }
            else {
                cnt[x] = mutableListOf(i)
            }
        }

        var res = Int.MAX_VALUE
        for (v in cnt.values) {
            if (v.size < 3)
                continue
            for (i in 0..v.lastIndex - 2) {
                res = min(res, (v[i + 2] - v[i]) * 2)
            }
        }

        return if (res == Int.MAX_VALUE) -1 else res
    }
}

fun main() {
    val solution = Solution3741()
    check(solution.minimumDistance(intArrayOf(1,2,1,1,3)) == 6) {"test1"}
    check(solution.minimumDistance(intArrayOf(1,1,2,3,2,1,2)) == 8) {"test2"}
    check(solution.minimumDistance(intArrayOf(1)) == -1) {"test3"}
}
