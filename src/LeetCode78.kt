package leetcode.tryeasyproblem

import java.lang.Integer.max

class LeetCode78 {
    fun subsets(nums: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        answer.add(emptyList())
        fun getSubsets(set:MutableSet<Int>,index:Int){
            for(i in index until nums.size){
                val num = nums[i]
                if(set.contains(num)) continue
                set.add(num)
                answer.add(set.sorted())
                getSubsets(set,i+1)
                set.remove(num)
            }
        }
        getSubsets(mutableSetOf(),0)
        return answer
    }
}

fun main() {
    val cls=LeetCode78()
//    println(cls.findMaxLength(intArrayOf(0,1)))
    println(cls.subsets(intArrayOf(1,2,3)))
}
