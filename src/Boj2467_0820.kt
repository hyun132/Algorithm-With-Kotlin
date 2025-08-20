import java.util.*
import kotlin.math.abs

fun main() = with(Scanner(System.`in`)) {
    val n = readLine()!!.trim().toInt()
    val arr = readLine()!!.trim().split(" ").map { it.toInt() }.sorted()

    var l = 0
    var r = arr.size - 1

    var answer = Int.MAX_VALUE
    var a = 0
    var b = 0

    while (l < r) {
        val sum = arr[l] + arr[r]
        if (abs(sum) < answer) {
            answer = abs(sum)
            a = arr[l]
            b = arr[r]
        }
        if (sum == 0) {
            a = arr[l]
            b = arr[r]
            break
        }
        if (sum > 0) r--
        else l++
    }
    println("$a $b")
}
