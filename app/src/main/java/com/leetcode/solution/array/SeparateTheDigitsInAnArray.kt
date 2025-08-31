package com.leetcode.solution.array

import android.os.Build
import androidx.annotation.RequiresApi

class Solution2553 {
    fun separateDigits(nums: IntArray): IntArray {
        return nums.flatMap { it.toString().map { it.digitToInt() } }.toIntArray()
    }

    fun separateDigits1(nums: IntArray): IntArray {
        val res = mutableListOf<Int>()
        for (x in nums) {
            for (c in x.toString())
                res.add(c.digitToInt())
        }
        return res.toIntArray()
    }
}

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
fun main() {
    val solution = Solution2553()
    check(solution.separateDigits(intArrayOf(13,25,83,77)).contentEquals(intArrayOf(1,3,2,5,8,3,7,7))) {"testing1 wrong result"}
    check(solution.separateDigits(intArrayOf(7,1,3,9)).contentEquals(intArrayOf(7,1,3,9))) {"testing2 wrong result"}
}