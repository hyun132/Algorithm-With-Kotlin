import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().trim().split(" ").map { it.toInt() }
    val n = input[0]
    val k = input[1]
    val values = IntArray(n) { readLine().trim().toInt() }
    values.sort()

    val dp = IntArray(k + 1) { 100_001 }
    dp[0] = 0
    for (won in values) {
        for (i in won..k) {
            dp[i] = minOf(dp[i], dp[i - won] + 1)
        }
    }

    if (dp[k] == 100_001) println(-1)
    else println(dp[k])
}
