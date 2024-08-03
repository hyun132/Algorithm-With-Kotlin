import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val newInput = readLine().trim().split(" ").map { it.toInt() }
    val originAmount = newInput[0]
    val required = newInput[1]

    val lines = arrayListOf<Long>()
    for (i in 0 until originAmount) {
        lines.add(readLine().trim().toLong())
    }
    println(binarySearch(lines, required))
}

fun binarySearch(lines: ArrayList<Long>, required: Int): Long {
    var l = 1L
    var r = lines.max().toLong()
    var m = 0L
    var count = 0
    while (l <= r) {
        m = (l + r) / 2L
        count = lines.fold(0L) { cnt, len -> cnt + len.div(m) }.toInt()
        if (count >= required) l = m + 1
        else r = m - 1
    }
    return r
}
