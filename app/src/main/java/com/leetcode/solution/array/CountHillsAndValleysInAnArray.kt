package com.leetcode.solution.array

class Solution2210 {
    fun countHillValley(nums: IntArray): Int {
        var res = 0
        var pre = nums[0]
        for (i in 1..nums.size - 2) {
            val cur = nums[i]
            val next = nums[i + 1]
            if (cur == next)
                continue
            if (pre != cur && (cur > pre == cur > next))
                res++
            pre = cur
        }
        return res
    }
}

fun main() {
    val solution = Solution2210()
    check(solution.countHillValley(intArrayOf(2,4,1,1,6,5)) == 3) {"testing1 wrong result"}
    check(solution.countHillValley(intArrayOf(6,6,5,5,4,1)) == 0) {"testing2 wrong result"}
}
