package com.leetcode.solution.array

class Solution2717 {
    fun semiOrderedPermutation(nums: IntArray): Int {
        var mi = nums.size
        var mx = 1
        var mi_idx = 0
        var mx_idx = 0
        for ((i, x) in nums.withIndex()) {
            if (mi >= x) {
                mi = x
                mi_idx = i
            }
            if (mx <= x) {
                mx = x
                mx_idx = i
            }
        }
        return (nums.size - mx_idx - 1) + mi_idx - (if (mx_idx < mi_idx) 1 else 0)
    }
}

fun main() {
    val solution = Solution2717()
    check(
        solution.semiOrderedPermutation(
            intArrayOf(2,1,4,3)
        ) == 2
    ) { "testing1 wrong result" }
    check(
        solution.semiOrderedPermutation(
            intArrayOf(
                2,4,1,3
            )
        ) == 3
    ) { "testing2 wrong result" }
    check(solution.semiOrderedPermutation(intArrayOf(1,3,4,2,5)) == 0) { "testing3 wrong result" }
}
