package com.leetcode.solution.heap

import java.util.PriorityQueue

class Solution0786 {
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
//        val pq = PriorityQueue<IntArray> {a, b -> (b[0].toDouble() / b[1]).compareTo(a[0].toDouble() / a[1])}
        val pq = PriorityQueue<IntArray>( compareByDescending { it[0].toDouble() / it[1] })
        for (i in 0..arr.lastIndex - 1) {
            for (j in i + 1..arr.lastIndex) {
                val cur = arr[i].toDouble() / arr[j]
                if (pq.size < k || (cur < pq.peek()[0].toDouble() / pq.peek()[1])) {
                    if (pq.size == k) {
                        pq.poll()
                    }
                    pq.offer(intArrayOf(arr[i], arr[j]))
                }
            }
        }
        return pq.poll()
    }
}

fun main() {
    val solution = Solution0786()
    check(solution.kthSmallestPrimeFraction(intArrayOf(1,2,3,5), 3).contentEquals(intArrayOf(2,5))) {"test1"}
    check(solution.kthSmallestPrimeFraction(intArrayOf(1,7), 1).contentEquals(intArrayOf(1,7))) {"test2"}
}
