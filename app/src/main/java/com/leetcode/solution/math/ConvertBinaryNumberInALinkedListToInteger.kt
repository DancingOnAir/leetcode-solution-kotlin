package com.leetcode.solution.math

import java.math.BigInteger

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution1290 {
    fun getDecimalValue(head: ListNode?): Int {
        var p = head
        var res = 0
        while (p != null) {
            res *= 2
            res += p.`val`
            p = p.next
        }
        return res
    }
}

fun main() {
    val solution = Solution1290()
    var node1 = ListNode(1)
    var node2 = ListNode(0)
    var node3 = ListNode(1)
    node1.next = node2
    node2.next = node3

    check(solution.getDecimalValue(node1) == 5) { "wrong result" }
    check(solution.getDecimalValue(ListNode(0)) == 0) { "wrong result" }
}
