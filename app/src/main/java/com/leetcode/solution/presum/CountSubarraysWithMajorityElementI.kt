package com.leetcode.solution.presum

class Solution3737 {
    fun countMajoritySubarrays(nums: IntArray, target: Int): Int {
        var dp = 0
        var res = 0
        val n = nums.size
        var ps = n
        val cnt = MutableList(2 * n + 1) {0}
        cnt[ps] = 1
        for (x in nums) {
            if (x == target) {
                dp += cnt[ps++]
            }
            else {
                dp -= cnt[--ps]
            }

            res += dp
            cnt[ps] += 1
        }
        return res
    }
}

fun main() {
    val solution = Solution3737()
    check(solution.countMajoritySubarrays(intArrayOf(1,2,2,3), 2) == 5) {"test1"}
    check(solution.countMajoritySubarrays(intArrayOf(1,1,1,1), 1) == 10) {"test2"}
    check(solution.countMajoritySubarrays(intArrayOf(1,2,3), 4) == 0) {"test3"}
}
