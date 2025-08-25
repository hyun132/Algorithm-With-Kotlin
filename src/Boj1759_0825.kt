import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val st = StringTokenizer(readLine())
    val L = st.nextToken().toInt()
    val C = st.nextToken().toInt()

    val arr = readLine()!!.trim().split(" ").sorted()
    val vowels = setOf('a', 'e', 'i', 'o', 'u')

    val current = Array<Char>(L) { 'A' }
    val sb = StringBuilder()
    fun foundCases(depth: Int, start: Int, vowelCnt: Int) {
        if (depth == L) {
            if (vowelCnt > 0 && (L - vowelCnt) > 1) sb.append(current.joinToString("")).append("\n")
            return
        }

        for (i in start until arr.size) {
            current[depth] = arr[i][0]
            foundCases(depth + 1, i + 1, if (vowels.contains(arr[i][0])) vowelCnt + 1 else vowelCnt)
        }
    }

    foundCases(0, 0, 0)
    println(sb.toString())

}
