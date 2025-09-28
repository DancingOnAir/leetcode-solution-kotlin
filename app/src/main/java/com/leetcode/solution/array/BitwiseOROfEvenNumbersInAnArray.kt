package com.leetcode.solution.array

class Solution3688 {
    fun evenNumberBitwiseORs(nums: IntArray): Int {
        var res = 0
        for (x in nums) {
            if (x % 2 == 0)
                res = res or x
        }
        return res
    }
}

fun main() {
    val solution = Solution3688()
    check(solution.evenNumberBitwiseORs(intArrayOf(1,2,3,4,5,6)) == 6) {"testing1 wrong result"}
    check(solution.evenNumberBitwiseORs(intArrayOf(7,9,11)) == 0) {"testing2 wrong result"}
    check(solution.evenNumberBitwiseORs(intArrayOf(1,8,16)) == 24) {"testing3 wrong result"}
}
