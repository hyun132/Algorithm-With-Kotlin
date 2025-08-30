import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val firstLine = readLine()!!.split(" ").map { it.toInt() }

    val n = firstLine[0]
    val m = firstLine[1]

    val arr = IntArray(n) { readLine()!!.trim().toInt() }.sorted()

    var l = 0
    var r = 1

    var minDiff = Int.MAX_VALUE
    while (l < r && r < n) {
        if (arr[r] - arr[l] >= m) {
            if (minDiff > arr[r] - arr[l]) minDiff = arr[r] - arr[l]
            l++
            if (l == r) r++
        } else {
            r++
        }
    }

    println(minDiff)
}
