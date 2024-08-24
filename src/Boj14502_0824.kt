import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var board: Array<Array<Int>>
lateinit var copiedBoard: Array<Array<Int>>
lateinit var availablePoints: MutableList<Pair<Int, Int>>
var xSize: Int = 0
var ySize: Int = 0
var safeArea = 0

val dy = arrayOf(0, 1, 0, -1)
val dx = arrayOf(1, 0, -1, 0)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val size = readLine().trim().split(" ").map { it.toInt() }

    ySize = size[0]
    xSize = size[1]

    board = Array<Array<Int>>(ySize) { Array<Int>(xSize) { 0 } }
    copiedBoard = Array<Array<Int>>(ySize) { Array<Int>(xSize) { 0 } }
    availablePoints = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until ySize) {
        board[i] = readLine().trim().split(" ").map { it.toInt() }.toTypedArray()
        board[i].forEachIndexed { index, num -> if (num == 0) availablePoints.add(Pair(i, index)) }
    }
    //dfs로 3개씩 고른다.
    selectWallPoint(0, 0)

    println(safeArea)
}

fun selectWallPoint(start: Int, depth: Int) {
    if (depth >= 3) {
        val temp = getSizeOfSafeArea()
        if (safeArea < temp) safeArea = temp
        return
    }

    for (i in start until availablePoints.size) {
        val cur = availablePoints[i]
        if (board[cur.first][cur.second] == 0) {
            board[cur.first][cur.second] = 4
            selectWallPoint(i + 1, depth + 1)
            board[cur.first][cur.second] = 0
        }
    }
}

fun getSizeOfSafeArea(): Int {
    board.forEachIndexed { index, ints ->
        copiedBoard[index] = ints.clone()
    }

    for (y in 0 until ySize) {
        for (x in 0 until xSize) {
            if (copiedBoard[y][x] == 2) {
                spread(y, x)
            }
        }
    }
    return copiedBoard.fold(0) { sum, row ->
        sum + row.count { it == 0 }
    }
}

fun spread(y: Int, x: Int) {
    val q = ArrayDeque<Pair<Int, Int>>()
    q.add(Pair(y, x))

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        for (i in 0 until 4) {
            val ny = cur.first + dy[i]
            val nx = cur.second + dx[i]

            if (ny < 0 || nx < 0 || ny >= ySize || nx >= xSize) continue
            if (copiedBoard[ny][nx] == 0) {
                copiedBoard[ny][nx] = 3
                q.add(Pair(ny, nx))
            }
        }
    }
}
