package com.leetcode.solution.math

class Solution0728 {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        return (left .. right).filter { x -> x.toString().all { (it != '0') && (x % (it - '0') == 0) } }
    }

    fun selfDividingNumbers1(left: Int, right: Int): List<Int> {
        return (left..right).filter { num -> "$num".all { (it != '0') && (num % (it - '0') == 0) } }
    }
}

fun main() {
    val solution = Solution0728()
    check(solution.selfDividingNumbers(1,22) == listOf(1,2,3,4,5,6,7,8,9,11,12,15,22)) { "testing1 wrong result" }
    check(solution.selfDividingNumbers(47,85) == listOf(48,55,66,77)) { "testing2 wrong result" }
}
