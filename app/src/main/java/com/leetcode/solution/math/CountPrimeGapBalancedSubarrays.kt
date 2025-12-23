package com.leetcode.solution.math

import java.util.PriorityQueue
import kotlin.math.sqrt

class Solution3589 {
    fun Int.isPrime(): Boolean {
        return when {
            this == 2 || this == 3 -> true
            this <= 1 || this % 2 == 0 || this % 3 == 0 -> false
            else -> {
                for (i in 5..sqrt(this.toDouble()).toInt()) {
                    if (this % i == 0 || this % (i + 2) == 0)
                        return false
                }
                return true
            }
        }
    }

    fun sieveOfEratosthenes(n: Int): List<Int> {
        if (n < 2)
            return emptyList()
        val isPrime = BooleanArray(n + 1) { true }
        isPrime[0] = false
        isPrime[1] = false
        for (i in 2..sqrt(n.toDouble()).toInt()) {
            if (isPrime[i]) {
                for (j in i * i..n step i) {
                    isPrime[j] = false
                }
            }
        }
        return (2..n).filter { isPrime[it] }
    }

    fun primeSubarray(nums: IntArray, k: Int): Int {
        var last = -1
        var last2 = -1
        val minQ = ArrayDeque<Int>()
        val maxQ = ArrayDeque<Int>()
        var left = 0
        var res = 0
        for ((i, x) in nums.withIndex()) {
            if (x.isPrime()) {
                last2 = last
                last = i

                while (minQ.isNotEmpty() && x <= nums[minQ.last()]) {
                    minQ.removeLast()
                }
                minQ.add(i)
                while (maxQ.isNotEmpty() && x >= nums[maxQ.last()]) {
                    maxQ.removeLast()
                }
                maxQ.add(i)

                while (nums[maxQ.first()] - nums[minQ.first()] > k) {
                    left++
                    if (minQ.first() < left)
                        minQ.removeFirst()
                    if (maxQ.first() < left)
                        maxQ.removeFirst()
                }
            }
            res += last2 - left + 1
        }
        return res
    }
}

fun main() {
    val solution = Solution3589()
    check(solution.primeSubarray(intArrayOf(1,2,3), 1) == 2) {"test1"}
    check(solution.primeSubarray(intArrayOf(2,3,5,7), 3) == 4) {"test2"}
}
