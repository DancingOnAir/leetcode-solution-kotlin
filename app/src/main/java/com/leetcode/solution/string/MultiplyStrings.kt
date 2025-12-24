package com.leetcode.solution.string

class Solution0043 {
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

    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0")
            return "0"

        val res = IntArray(num1.length + num2.length)
        for (i in num1.lastIndex downTo 0) {
            val a = num1[i] - '0'
            if (a == 0)
                continue
            for (j in num2.lastIndex downTo 0) {
                val b = num2[j] - '0'
                val tot = (res[i + j + 1] + a * b)
                res[i + j + 1] = tot % 10
                res[i + j] += tot / 10
            }
        }

        return buildString {
            val start = if (res[0] == 0) 1 else 0
            for (i in start..res.lastIndex) append(res[i])
        }
    }

    fun multiply1(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0")
            return "0"
        var res = ""
        var carry = 0
        var j = num2.lastIndex
        while (j >= 0) {
            var i = num1.lastIndex
            val b = num2[j].digitToInt()
            var cur = ""
            while (i >= 0 || carry > 0) {
                val a = if (i >= 0) num1[i].digitToInt() else 0
                cur += ((a * b + carry) % 10).toString()
                carry = (a * b + carry) / 10
                i--
            }
            res = addStrings (res, cur.reversed() + "0".repeat(num2.lastIndex - j))
            j--
        }
        return res
    }
}

fun main() {
    val solution = Solution0043()
    check(solution.multiply("2", "3") == "6") { "test1" }
    check(solution.multiply("123", "456") == "56088") { "test2" }
}
