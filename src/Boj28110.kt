import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var n = readLine().trim().toInt()

    var diff = 0
    var level = Int.MAX_VALUE
    val originArr = readLine().trim().split(" ").map { n -> n.toInt() }.sorted()

    for (i in 1 until originArr.size) {
        if (diff/2 < (originArr[i]-originArr[i-1])/2) {
            diff = originArr[i]-originArr[i-1]

            level = originArr[i-1] + diff/2
        }
    }

    if(level == Int.MAX_VALUE) level= -1
    println(level)
}
