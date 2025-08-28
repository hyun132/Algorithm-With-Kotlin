import java.util.*
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    st = StringTokenizer(readLine())
    val arr = IntArray(n) { st.nextToken().toInt() }
    val answer = IntArray(n) { 0 }

    val stack = Stack<Int>()
    for (i in n - 1 downTo 0) {
        while (stack.isNotEmpty() && arr[stack.peek()] < arr[i]) {
            answer[stack.pop()] = i + 1
        }
        stack.add(i)
    }
    println(answer.joinToString(" "))
}
