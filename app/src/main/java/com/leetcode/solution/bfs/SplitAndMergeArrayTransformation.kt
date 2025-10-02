package com.leetcode.solution.bfs

import java.util.LinkedList
import java.util.Queue

class Solution3690 {
    fun minSplitMerge(nums1: IntArray, nums2: IntArray): Int {
        val start = nums1.toList()
        val target = nums2.toList()
        if (start == target)
            return 0

        val n = nums1.size
        val visited = mutableSetOf(start)
        val q: Queue<List<Int>> = LinkedList(listOf(start))
        var res = 0

        while (q.isNotEmpty()) {
            repeat(q.size) {
                val cur = q.poll()
                if (cur == target)
                    return res

                for (l in 0 until n) {
                    for (r in l + 1 until n + 1) {
                        val sub = cur.subList(l, r)
                        val rest = cur.slice(0 until l) + cur.slice(r until cur.size)
                        for (j in 0..rest.size) {
                            val newState = rest.take(j) + sub + rest.drop(j)
                            if (visited.add(newState)) {
                                q.add(newState)
                            }
                        }
                    }
                }
            }
            res++
        }
        return -1
    }
}

fun main() {
    val solution = Solution3690()
    assert(solution.minSplitMerge(intArrayOf(3,1,2), intArrayOf(1,2,3)) == 1) { "test1 wrong result" }
    assert(solution.minSplitMerge(intArrayOf(1,1,2,3,4,5), intArrayOf(5,4,3,2,1,1)) == 3) { "test2 wrong result" }
}
