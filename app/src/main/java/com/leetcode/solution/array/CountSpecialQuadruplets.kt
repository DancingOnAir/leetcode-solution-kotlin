package com.leetcode.solution.array

class Solution1995 {
    fun countQuadruplets(nums: IntArray): Int {
        nums.sort()
        var res = 0
        for (i in 0..nums.size - 4) {
            for (j in i + 1..nums.size - 3) {
                for (k in j + 1..nums.size - 2) {
                    for (l in k + 1..nums.size - 1) {
                        if (nums[l] == nums[i] + nums[j] + nums[k])
                            res++
                    }
                }
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution1995()
    check(solution.countQuadruplets(intArrayOf(1,2,3,6)) == 1) {"testing1 wrong result"}
    check(solution.countQuadruplets(intArrayOf(3,3,6,4,5)) == 0) {"testing2 wrong result"}
    check(solution.countQuadruplets(intArrayOf(1,1,1,3,5)) == 4) {"testing3 wrong result"}
}
