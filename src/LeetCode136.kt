package leetcode.tryeasyproblem

class LeetCode136 {
    fun singleNumber(nums: IntArray): Int {
        val numSet = mutableSetOf<Int>()

        for (num in nums){
            if (numSet.contains(num)) numSet.remove(num)
            else numSet.add(num)
        }
        numSet.remove(1)
        if (numSet.size>0) return numSet.first()
        return 1
    }

    //xor을 이용한 방법
    fun singleNumber2(nums: IntArray):Int{
        var result=0
        for(num in nums)
        {
            result=result xor num
        }
        return result
    }
}
fun main() {
    val cls=LeetCode136()
    println(cls.singleNumber(intArrayOf(4,1,2,1,2)))
}
