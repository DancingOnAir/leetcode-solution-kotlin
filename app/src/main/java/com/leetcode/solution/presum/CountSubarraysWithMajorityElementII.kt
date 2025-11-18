package com.leetcode.solution.presum

class Solution3739 {
    fun countMajoritySubarrays(nums: IntArray, target: Int): Long {
        val n = nums.size
        // 防止ps作为下标时越界
        val cnt = MutableList(n * 2 + 1) {0}
        var ps = n
        cnt[ps] = 1
        var res = 0L
        var dp= 0

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
    val solution = Solution3739()
    check(solution.countMajoritySubarrays(intArrayOf(1,2,2,3), 2) == 5L) {"test1"}
    check(solution.countMajoritySubarrays(intArrayOf(1,1,1,1), 1) == 10L) {"test2"}
    check(solution.countMajoritySubarrays(intArrayOf(1,2,3), 4) == 0L) {"test3"}
}
