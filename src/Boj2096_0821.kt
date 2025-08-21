import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = readLine()!!.trim().toInt()

    val arr = Array(n) { readLine()!!.trim().split(" ").map { it.toInt() }.toIntArray() }
    val minDp = Array(n + 1) { IntArray(3) { Int.MAX_VALUE } }
    val maxDp = Array(n + 1) { IntArray(3) { 0 } }
    minDp[0] = arr[0]
    maxDp[0] = arr[0]

    for(i in 1 until n) {
        minDp[i][0] = arr[i][0]+ minOf(minDp[i - 1][0], minDp[i - 1][1])
        minDp[i][2] = arr[i][2]+ minOf(minDp[i - 1][2], minDp[i - 1][1])
        minDp[i][1] = arr[i][1]+ minOf(minDp[i - 1][0], minDp[i - 1][2], minDp[i - 1][1])

        maxDp[i][0] = arr[i][0]+ maxOf(maxDp[i - 1][0], maxDp[i - 1][1])
        maxDp[i][2] = arr[i][2]+ maxOf(maxDp[i - 1][2], maxDp[i - 1][1])
        maxDp[i][1] = arr[i][1]+ maxOf(maxDp[i - 1][0], maxDp[i - 1][2], maxDp[i - 1][1])
    }

    println("${maxDp[n - 1].max()} ${minDp[n - 1].min()}")
}
