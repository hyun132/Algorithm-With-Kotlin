package leetcode.tryeasyproblem


class LeetCode532 {
    fun findPairs(nums: IntArray, k: Int): Int {
        if (nums.size == 1) return 0
        val m  = mutableMapOf<Int, Int>()
        nums.forEach {
            m[it] = m.getOrDefault(it,0)+1
        }
        var count = 0
        m.forEach { (key, value) ->
            if (k == 0) {
                if (value >= 2) {
                    count++
                }
            } else {
                if (m.containsKey(key+k)) {
                    count++
                }
            }
        }
        return count
    }
}

fun main() {
    val cls = LeetCode532()
//    println(cls.findMaxLength(intArrayOf(0,1)))
//    println(cls.findPairs(intArrayOf(3, 1, 4, 1, 5), 2))
//    println(cls.findPairs(intArrayOf(1, 2, 3, 4, 5), 1))
    println(cls.findPairs(intArrayOf(1, 3, 1, 5, 4), 0))
}
