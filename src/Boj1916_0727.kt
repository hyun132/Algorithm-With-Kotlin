import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val place = readLine().trim().toInt()
    val routeNumber = readLine().trim().toInt()

    val routeMap = mutableMapOf<Int, MutableList<Route>>()
    val q = ArrayDeque<Int>()

    val costArray = Array<Int>(place + 1) { Int.MAX_VALUE }
    for (i in 0 until routeNumber) {
        val input = readLine().trim().split(" ").map { it.toInt() }
        routeMap.putIfAbsent(input[0], mutableListOf())
        routeMap[input[0]]?.add(Route(input[1], input[2]))
    }

    val lastLine = readLine().trim().split(" ").map { it.toInt() }
    val departure = lastLine[0]
    val destination = lastLine[1]
    costArray[departure]=0
    q.add(departure)

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        if (routeMap[cur] == null) continue
        for (route in routeMap[cur]!!) {
            if (costArray[cur]+route.cost < costArray[route.to]){
                costArray[route.to] = costArray[cur]+route.cost
                if (!q.contains(route.to)) q.add(route.to)
            }
        }
    }
    println(costArray[destination])
}

data class Route(
    val to: Int,
    val cost: Int
)
