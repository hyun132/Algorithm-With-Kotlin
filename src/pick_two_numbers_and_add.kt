fun main() {
    val arr= intArrayOf(2,1,3,4,1)
    solution(arr)
}

fun solution(numbers: IntArray): IntArray {
    val answer:MutableList<Int> = mutableListOf()

    for (i in 0 until numbers.size-1){
        for (j in i+1 until numbers.size){
            answer.add(numbers[i]+numbers[j])
        }
    }
    answer.sort()
    return answer.distinct().toIntArray()
}

