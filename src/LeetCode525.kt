package leetcode.tryeasyproblem

import java.lang.Integer.max

class LeetCode525 {
    fun findMaxLength(nums: IntArray): Int {
        val numberIndex = HashMap<Int,Int>()
        var state=0
        var maxLength=0
        numberIndex[0]=-1
        nums.forEachIndexed { index, value ->
            if (value==1) state++
            else state--

            if (numberIndex.containsKey(state)) maxLength = max(maxLength,index - numberIndex[state]!!)
            else numberIndex[state] = index
        }
        return maxLength
    }
}

fun main() {
    val cls=LeetCode525()
//    println(cls.findMaxLength(intArrayOf(0,1)))
    println(cls.findMaxLength(intArrayOf(0,1,0)))
}
