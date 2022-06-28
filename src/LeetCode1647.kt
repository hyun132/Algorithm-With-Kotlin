import kotlin.math.max
import kotlin.math.min

class LeetCode1647 {
    fun minDeletions(s: String): Int {
        // 나는 map으로 풀었지만 알파벳은 26개이므로, IntArray를 사용하여 효율적으로 풀 수 있다
        val alphabetMap = mutableMapOf<Char, Int>()

        for (ch in s) {
            alphabetMap[ch] = (alphabetMap[ch] ?: 0) + 1
        }

        var answer = 0
        var lastNumber = s.length
        for (num in alphabetMap.values.sorted().reversed()) {
            lastNumber = min(lastNumber, num)
            answer += (num - lastNumber)
            lastNumber = max(0, lastNumber-1)
        }

        return answer
    }
}

fun main() {
    val solution = LeetCode1647()
//    println(solution.minDeletions("ceabaacb")) //2
    println(solution.minDeletions("accdcdadddbaadbc")) // 1
}
