package com.leetcode.solution.presum

import kotlin.math.max

class Solution3714 {
    fun longestBalanced(s: String): Int {
        val n = s.length
        var res = 0
        var i = 0
        // 一种字母
        while (i < n) {
            val start = i
            i++
            while (i < n && s[i] == s[i - 1]) {
                i++
            }
            res = max(res, i - start)
        }
        // 两种字母
        fun f(x: Char, y: Char) {
            var i = 0
            while (i < n) {
                val pos = mutableMapOf<Int, Int>()
                pos[0] = i - 1
                var diff = 0
                while (i < n && (s[i] == x || s[i] == y)) {
                    diff += if (s[i] == x) 1 else -1
                    if (pos.contains(diff)) {
                        res = max(res, i - pos[diff]!!)
                    }
                    else {
                        pos[diff] = i
                    }
                    i++
                }
                i++
            }
        }
        f('a', 'b')
        f('b', 'c')
        f('a', 'c')

        // 三种字母
        // 默认的 equals() 和 hashCode(): IntArray（以及其他原生数组类型如 Array<T>）继承自 Any?，它们的 equals() 方法默认是比较引用（identity），而不是比较内容（values）。同样，hashCode() 默认也是基于对象的内存地址计算的。
        // 后果: 当你创建两个内容相同但内存地址不同的 IntArray 时（例如 intArrayOf(1, 2) 和另一个 intArrayOf(1, 2)），它们会被认为是两个不同的 Key，即使你希望它们被视为同一个 Key。map.contains(p) 和 map[p] 将无法按预期工作。
        val pos = mutableMapOf<List<Int>, Int>()
        pos[listOf(0, 0)] = -1
        val cnt = mutableMapOf<Char, Int>()
        for ((i, c) in s.withIndex()) {
            cnt[c] = cnt.getOrDefault(c, 0) + 1
            val p = listOf(cnt.getOrDefault('a', 0) - cnt.getOrDefault('b', 0), cnt.getOrDefault('b', 0) - cnt.getOrDefault('c', 0))
            if (pos.contains(p)) {
                res = max(res, i - pos[p]!!)
            }
            else {
                pos[p] = i
            }
        }
        return res
    }

    // TLE
    fun longestBalanced1(s: String): Int {
        val ps = mutableListOf<IntArray>()
        val cnt = MutableList(3) {0}
        ps.add(cnt.toIntArray())
        for (c in s) {
            cnt[c - 'a']++
            ps.add((cnt.toIntArray()))
        }

        var res = 0
        // Using List<*> as key type to accommodate mixed types
        val first = mutableMapOf<List<*>, Int>()
        for ((i, p) in ps.withIndex()) {
            val a = p[0]
            val b = p[1]
            val c = p[2]

            val keys = listOf(
                listOf("abc", a - b, b - c),
                listOf("ab", a - b, c),
                listOf("bc", b - c, a),
                listOf("ca", a - c, b),
                listOf("a", b, c),
                listOf("b", c, a),
                listOf("c", a, b)
            )

            for (k in keys) {
                res = max(res, i - first.getOrDefault(k, i))
                if (!first.containsKey(k))
                    first[k] = i
            }

        }

        return res
    }
}

fun main() {
    val solution = Solution3714()
//    check(solution.longestBalanced("abbac") == 4) {"test1"}
    check(solution.longestBalanced("aabcc") == 3) {"test2"}
    check(solution.longestBalanced("aba") == 2) {"test3"}
}