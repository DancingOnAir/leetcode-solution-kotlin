package com.leetcode.solution.array

class Solution3606 {
    fun validateCoupons(code: Array<String>, businessLine: Array<String>, isActive: BooleanArray): List<String> {
        val re = "[a-zA-Z0-9_]+$".toRegex()
        val validCategories = setOf<String>("electronics", "grocery", "pharmacy", "restaurant")
        val validCoupon = mutableListOf<Pair<String, String>>()
        for (i in code.indices) {
            if (isActive[i] && businessLine[i] in validCategories && code[i].matches(re)) {
                validCoupon.add(businessLine[i] to code[i])
            }
        }

        return validCoupon.sortedWith(compareBy({it.first}, {it.second})).map { it.second }
    }

    fun validateCoupons1(code: Array<String>, businessLine: Array<String>, isActive: BooleanArray): List<String> {
        // 仅允许字母/数字/下划线
        val re = "[a-zA-Z0-9_]+$".toRegex()
        val validCategories = listOf(
            "electronics",
            "grocery",
            "pharmacy",
            "restaurant",
        )

        val validCoupons = code.indices
            .asSequence()
            .filter { isActive[it] }
            .filter { businessLine[it] in validCategories }
            .filter { code[it].matches(re) }
            .map { businessLine[it] to code[it] }
            .toList()
        print(validCoupons)
        return validCoupons.sortedWith(
            compareBy<Pair<String, String>> { validCategories.indexOf(it.first) }.thenBy { it.second }
        ).map { it.second }
    }
}

fun main() {
    val solution = Solution3606()
    check(solution.validateCoupons(arrayOf("SAVE20","","PHARMA5","SAVE@20"), arrayOf("restaurant","grocery","pharmacy","restaurant"), booleanArrayOf(true,true,true,true)) == arrayOf("PHARMA5","SAVE20")) {"testing1"}
    check(solution.validateCoupons(arrayOf("GROCERY15","ELECTRONICS_50","DISCOUNT10"), arrayOf("grocery","electronics","invalid"),
        booleanArrayOf(false,true,true)) == arrayOf("ELECTRONICS_50")) {"testing2"}
}
