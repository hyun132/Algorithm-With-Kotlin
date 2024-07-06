import kotlin.math.sqrt
import java.util.*

class FindNumberOfDecimalsInBaseK_0706 {
    val primes= mutableSetOf<Long>()
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0
        var nums = n.toString(k).split("0").filter { it.isNotEmpty() && it != "1"}.map { it.toLong() }.sortedDescending()


        for (num in nums) {
            if (primes.contains(num)){
                answer+=1
                continue
            }
           else if (isPrime(num)) answer+=1
        }
        return answer
    }

    fun isPrime(maxVal: Long): Boolean {
        for (i in 2..sqrt(maxVal.toDouble()).toLong()) {
            if (maxVal % i == 0.toLong()) return false
        }
        primes.add(maxVal)
        return true
    }
}
