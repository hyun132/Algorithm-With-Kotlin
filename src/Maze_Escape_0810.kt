class Maze_Escape_0810 {
    fun solution(maps: Array<String>): Int {
        var answer: Int = 0
        val map = Array(maps.size) { Array(maps[0].length) { 0 } }
        val map2 = Array(maps.size) { Array(maps[0].length) { 0 } }
        val q = ArrayDeque<Point>()
        var start = Point(0, 0)
        var end = Point(0, 0)
        var lever = Point(0, 0)
        maps.forEachIndexed { y, row ->
            row.forEachIndexed { x, ch ->
                map[y][x] = when (ch) {
                    'X' -> -1
                    'S' -> {
                        start = Point(y, x, false)
                        1
                    }
                    'E' -> {
                        end = Point(y, x, false)
                        2
                    }
                    'L' -> {
                        lever = Point(y, x, false)
                        3
                    }
                    else -> 0
                }
                map2[y][x] = map[y][x]
            }
        }

        val dy = arrayOf(0, 1, 0, -1)
        val dx = arrayOf(1, 0, -1, 0)

        q.add(start)
        while (q.isNotEmpty()) {
            var size = q.size
            answer++
            for (k in 0 until size) {
                var cur = q.removeFirst()

                for (i in dy.indices) {
                    val ny = cur.y + dy[i]
                    val nx = cur.x + dx[i]
                    if (end.y == ny && end.x == nx && cur.lever) return answer
                    if (ny < 0 || nx < 0 || ny >= map.size || nx >= map[0].size) continue
                    if (cur.lever) {
                        if (map2[ny][nx] < 0) continue
                        map2[ny][nx] = -1
                        q.add(Point(ny, nx, true))
                    } else {
                        if (map[ny][nx] < 0) continue
                        else {
                            map[ny][nx] = -1
                            if (ny == lever.y && nx == lever.x) {
                                map2[ny][nx] = -1
                                q.add(Point(ny, nx, true))
                            }
                            else {
                                q.add(Point(ny, nx, false))
                            }
                        }
                    }
                }
            }
        }
        return -1
    }
}

data class Point(
    val y: Int,
    val x: Int,
    val lever: Boolean = false
)
