package leetcode.tryeasyproblem

class Number_of_consecutive_subsequence_sums {

    fun solution(elements: IntArray): Int {
        val origin = elements + elements

        val temp = IntArray(elements.size)
        val caseSet = mutableSetOf<Int>()

        for (i in 0 until elements.size){
            for(j in i until i+elements.size){
                temp[j-i] += origin[j]
            }
            caseSet.addAll(temp.toSet())
        }

        return caseSet.size
    }

}

fun main() {
    val solution = Number_of_consecutive_subsequence_sums()
    println(solution.solution(intArrayOf(7,9,1,1,4)))
}