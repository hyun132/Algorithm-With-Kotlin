import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

var added = arrayOf<Boolean>()
var N = 0
var answer = Int.MAX_VALUE
val ingredients = mutableListOf<Ingredient>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    N = readLine().trim().toInt()
    added = Array(N) { false }

    for (i in 0 until N) {
        val input = StringTokenizer(readLine())

        ingredients.add(Ingredient(input.nextToken().toInt(), input.nextToken().toInt()))
    }

    dfs(0)
    println(answer)
}

fun dfs(start: Int) {
    var sum = 0
    var mul = 0
    ingredients.filterIndexed { idx, _ -> added[idx] }.forEach {
        sum += it.bitter
        if (mul == 0) mul = it.acid
        else mul *= it.acid
    }
    if (sum > 0 && answer > abs(sum - mul)) answer = abs(sum - mul)

    if (start == N) return

    for (i in start until N) {
        added[i] = true
        dfs(i + 1)
        added[i] = false
        dfs(i + 1)
    }
}

data class Ingredient(
    val acid: Int,
    val bitter: Int
)
