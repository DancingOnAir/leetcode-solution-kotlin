package com.leetcode.solution.string

class Solution3692 {
    fun majorityFrequencyGroup(s: String): String {
        val cnt = s.groupingBy { it }.eachCount()
        // 2. 按频率分组：Map<频率, 字符列表>
        val m = cnt.entries.groupBy({ it.value }, { it.key })
        val res = m.entries.maxWithOrNull(compareBy<Map.Entry<Int, List<Char>>> { it.value.size }.thenBy { it.key } )
        return res?.value?.joinToString("")?:""
    }
}

fun main() {
    val solution = Solution3692()
    check(solution.majorityFrequencyGroup("aaabbbccdddde") == "ab") {"test1 wrong result"}
    check(solution.majorityFrequencyGroup("abcd") == "abcd") {"test2 wrong result"}
    check(solution.majorityFrequencyGroup("pfpfgi") == "fp") {"test3 wrong result"}
}
