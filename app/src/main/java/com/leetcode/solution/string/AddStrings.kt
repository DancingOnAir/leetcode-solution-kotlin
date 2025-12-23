package com.leetcode.solution.string

class Solution0415 {
    fun addStrings(num1: String, num2: String): String {
        var i = num1.lastIndex
        var j = num2.lastIndex
        var carry = 0
        var res = ""
        while (i >= 0 || j >= 0 || carry > 0) {
            val a = if (i >= 0) num1[i].digitToInt() else 0
            val b = if (j >= 0) num2[j].digitToInt() else 0
            res += (((a + b + carry) % 10).toString())
            carry = (a + b + carry) / 10
            i--
            j--
        }

        return res.reversed()
    }
}

fun main() {
    val solution = Solution0415()
    check(solution.addStrings("11", "123") == "134") {"test1"}
    check(solution.addStrings("456", "77") == "533") {"test2"}
    check(solution.addStrings("0", "0") == "0") {"test3"}
}
