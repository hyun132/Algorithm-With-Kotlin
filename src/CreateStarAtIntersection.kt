import kotlin.math.max
import kotlin.math.min

class CreateStarAtIntersection {
    fun solution(line: Array<IntArray>): Array<String> {
        val lines = line.map { arr: IntArray -> Line(arr[0].toLong(), arr[1].toLong(), arr[2].toLong()) }
        val points = mutableListOf<Pair<Int, Int>>()
        var minX: Long = Int.MAX_VALUE.toLong()
        var minY: Long = Int.MAX_VALUE.toLong()
        for (i in lines.indices) {
            for (j in i + 1 until lines.size) {
                val point = findCrossPoint(lines[i], lines[j])
                point?.let {
                    minX = min(minX, point.first.toLong())
                    minY = min(minY, point.second.toLong())
                    points.add(point.first to point.second)
                }
            }
        }
        val minSizeX = 0 - minX
        val minSizeY = 0 - minY
        var endX = 0
        var map = MutableList<Array<String>>(1000) { Array<String>(1000) { "." } }
        points.forEach {
            map[(minSizeY + it.second).toInt()][(minSizeX + it.first).toInt()] = "*"
            endX = max(endX, (minSizeX + it.first).toInt())
        }

        var startY = 0
        while (map[startY].all { it == "." }) {
            startY++
        }
        var endY = map.size - 1
        while (map[endY].all { it == "." }) {
            endY--
        }

        map = map.subList(startY, endY + 1)
        return map.map { it.slice(IntRange(0, endX.toInt())).joinToString("") }.reversed().toTypedArray()
    }

    fun findCrossPoint(line1: Line, line2: Line): Pair<Int, Int>? {
        val x1 = (line1.b * line2.c.toLong() - line1.c * line2.b.toLong())
        val x2 = (line1.a * line2.b.toLong() - line1.b * line2.a.toLong())
        val y1 = (line1.c * line2.a.toLong() - line1.a * line2.c.toLong())
        val y2 = (line1.a * line2.b.toLong() - line1.b * line2.a.toLong())
        if (x2 == 0L || y2 == 0L) return null
        return if (x1 % x2 == 0L && y1 % y2 == 0L) {
            (x1 / x2).toInt() to (y1 / y2).toInt()
        } else null
    }


    data class Line(
        val a: Long,
        val b: Long,
        val c: Long
    )
}
