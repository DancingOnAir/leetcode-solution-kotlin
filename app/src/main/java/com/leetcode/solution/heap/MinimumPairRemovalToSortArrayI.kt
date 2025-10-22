package com.leetcode.solution.heap

class Solution3507 {
    fun minimumPairRemoval(nums: IntArray): Int {
        if (nums.size < 2)
            return 0

        fun isSorted(arr: List<Int>): Boolean {
            for (i in 0..arr.size - 2) {
                if (arr[i] > arr[i + 1])
                    return false
            }
            return true
        }
        var res = 0
        val mutableNums = nums.toMutableList()
        while (!isSorted(mutableNums)) {
            var minSum = Int.MAX_VALUE
            var minIndex = -1
            for (i in 0..mutableNums.size - 2) {
                if (minSum > mutableNums[i] + mutableNums[i + 1]) {
                    minSum = mutableNums[i] + mutableNums[i + 1]
                    minIndex = i
                }
            }
            mutableNums[minIndex] = minSum
            mutableNums.removeAt(minIndex + 1)
            res++
        }
        return res
    }
}

fun main() {
    val solution = Solution3507()
    check(solution.minimumPairRemoval(intArrayOf(5,2,3,1)) == 2) {"test1 wrong result"}
    check(solution.minimumPairRemoval(intArrayOf(1,2,2)) == 0) {"test2 wrong result"}
}

