import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())

    val v = st.nextToken().toInt()
    val e = st.nextToken().toInt()

    st = StringTokenizer(readLine())
    val start = st.nextToken().toInt() - 1

    val arr = Array(v) { arrayListOf<Edge>() }

    val costArr = Array(v) { Int.MAX_VALUE }
    costArr[start] = 0

    for (i in 0 until e) {
        st = StringTokenizer(readLine())
        arr[st.nextToken().toInt() - 1].add(Edge(st.nextToken().toInt() - 1, st.nextToken().toInt()))
    }

    val q = PriorityQueue<Edge> { a, b ->
        a.w - b.w
    }
    q.add(Edge(start, 0))
    while (q.isNotEmpty()) {
        val cur = q.poll()

        if (costArr[cur.to] < cur.w) continue

        arr[cur.to].forEach { nxt ->
            if (costArr[nxt.to] > nxt.w + cur.w) {
                costArr[nxt.to] = nxt.w + cur.w
                q.add(Edge(nxt.to, nxt.w + cur.w))
            }
        }
        arr[cur.to].clear()
    }

    val sb = StringBuilder()
    costArr.forEach {
        if (it == Int.MAX_VALUE) sb.append("INF").append("\n")
        else sb.append(it).append("\n")
    }
    println(sb.toString())
}

data class Edge(
    val to: Int,
    val w: Int
)
