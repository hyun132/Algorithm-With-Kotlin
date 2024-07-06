import java.util.PriorityQueue

class FindBigNumber_0706 {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = IntArray(numbers.size){-1}

        val priorityQueue = PriorityQueue<Int> { o1, o2 -> numbers[o1] - numbers[o2] }
        for (i in numbers.indices){
            while (priorityQueue.isNotEmpty() && numbers[priorityQueue.peek()] < numbers[i]){
                answer[priorityQueue.poll()] = numbers[i]
            }
            priorityQueue.add(i)
        }

        return answer
    }
}
