package com.leetcode.solution.array

import android.os.Build
import androidx.annotation.RequiresApi

class Solution1909 {
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    fun canBeIncreasing(nums: IntArray): Boolean {
        val stk = mutableListOf<Int>()
        var cnt = 0
        for (x in nums) {
            if (stk.size > 1 && stk.last() > x) {
                if (cnt > 0) {
                    return false
                }
                stk.removeLast()
                cnt++
            }
            stk.addLast(x)
        }
        return true
    }
}

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
fun main() {
    val solution = Solution1909()
    check(solution.canBeIncreasing(intArrayOf(1,2,10,5,7))) {"testing1 wrong result"}
    check(solution.canBeIncreasing(intArrayOf(2,3,1,2))) {"testing2 wrong result"}
    check(solution.canBeIncreasing(intArrayOf(1,1,1))) {"testing3 wrong result"}
}
