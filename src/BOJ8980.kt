import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.math.min

var truck = IntArray(0)
var capacity=0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var input = br.readLine().split(" ").map { it.toInt() }
        val n = input[0]
        capacity = input[1]
        val packages = ArrayList<PostBox>()
        val numOfBoxes = br.readLine().trim().toInt()
        for (i in 0 until numOfBoxes) {
            input = br.readLine().split(" ").map { it.toInt() }
            packages.add(PostBox(from = input[0], to = input[1], amount = input[2]))
        }
        packages.sortedWith(
            Comparator.comparing<PostBox?, Int?>({ it.to }).thenComparing(Comparator.comparing({ -it.from }))
        )
        val newPackage = Array(n + 1) { ArrayDeque<PostBox>() }
        packages.forEach { newPackage[it.to].add(it) }

        val dp = IntArray(n + 1)
        truck = IntArray(n + 1)

        for(no in 1..n){
            newPackage[no].sortBy { -it.from }
            // 이 마을에 도착해야 할 짐 트럭에 싣기
            while (newPackage[no].isNotEmpty()){
                val pkg = newPackage[no].removeFirstOrNull()
                if (pkg == null) break

                val couldDeli = cnaThru(pkg.from,pkg.to)
                if (couldDeli == 0) break
                var pickUp = min(couldDeli, pkg.amount)
                for (i in pkg.from  until pkg.to) {
                    truck[i] += pickUp
                }
                dp[no]+=pickUp
            }
        }
        println(dp.sum())
}

fun cnaThru(from: Int, to: Int): Int {
    var result = capacity-truck[from]
    for (i in from  until to) {
        result = min(result, capacity-truck[i])
    }

    return result
}

data class PostBox(
    val from: Int,
    val to: Int,
    var amount: Int
)
