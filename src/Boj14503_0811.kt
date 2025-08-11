import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sizes = readLine().trim().split(" ").map { it.toInt() }
    val n = sizes[0]
    val m = sizes[1]

    val current = readLine().trim().split(" ").map { it.toInt() }.toTypedArray()
    val dir = current[2]
    val y = current[0]
    val x = current[1]
    val arr = Array(n) {
        readLine().trim().split(" ").map { it.toInt() }.toIntArray()
    }

    val dirY = intArrayOf(-1, 0, 1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)
    var answer = 0

    var nxt: Triple<Int, Int, Int>? = Triple(y, x, dir)
    while (nxt != null) {
        var cur = nxt
        nxt = null
        if (arr[cur.first][cur.second] == 0) { // 1. 현재 칸 아직 청소 안되었으면 청소
            answer++
            arr[cur.first][cur.second] = -1
        }
        var count = 0
        for (i in 0 until 4) {
            var ny = cur.first + dirY[i]
            var nx = cur.second + dirX[i]
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue
            if (arr[ny][nx] == 0) { //주변에 청소되지 않은 빈 칸 있으면
                count++ //빈칸 있음을 체크
                var ndir = (cur.third + 3) % 4 // 반시계 회전
                var nny = cur.first + dirY[ndir]
                var nnx = cur.second + dirX[ndir]
                if (nny < 0 || nnx < 0 || nny >= n || nnx >= m) continue
                if (arr[nny][nnx] == 0) { //앞 칸이 청소되지 않은 빈 칸이면 전진
                    nxt = Triple(nny, nnx, ndir)
                    break
                } else nxt = cur.copy(third = ndir)
            }
        }
        if (count == 0) { // 주변에 청소되지 않은 빈 칸이 없는 경우
            // 방향 유지하고 뒤로 한칸 후진
            var dirIdx = (cur.third + 2) % 4
            var ny = cur.first + dirY[dirIdx]
            var nx = cur.second + dirX[dirIdx]
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) break
            if (arr[ny][nx] != 1) { //후진할 수 있으면
                nxt = Triple(ny, nx, cur.third)
            } else break
        }
    }

    println(answer)
}
