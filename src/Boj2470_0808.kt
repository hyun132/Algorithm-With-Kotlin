import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().trim().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.sorted().toTypedArray()

    var l = 0
    var r = arr.size - 1
    var minDiff = Int.MAX_VALUE
    var left = 0
    var right = 0
    while (l < r) {
        val diff = arr[r] + arr[l]
        if (Math.abs(diff) < minDiff) {
            left = arr[l]
            right = arr[r]
            minDiff = Math.abs(diff)
        }

        if(diff>0) r--
        else l++
    }

    println("$left $right")
}
