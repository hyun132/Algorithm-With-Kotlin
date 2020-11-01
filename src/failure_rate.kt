import kotlin.system.exitProcess

fun main() {
    var stages= intArrayOf(2,1,2,6,2,4,3,3)
    var result =solution(5,stages)
    print(result.toString())

}

fun solution(N: Int, stages: IntArray): IntArray {

    var countArr = Array(N,{i-> arrayOf(0.0,0.0)})

    for (stage in stages){
        for (i in 0 until stage-1){
            countArr[i][0]+=1.0
            countArr[i][1]+=1.0
        }
        if (stage<=N) {
            countArr[stage - 1][0] += 1.0
        }
    }

    var answer = mutableListOf<DoubleArray>()
    var idx=1
    for (arr in countArr){
        answer.add(doubleArrayOf(idx.toDouble(),arr[1]/arr[0]))
        idx++

    }
    answer.sortBy { it[1] }
    return answer.map { it[0].toInt() }.toIntArray()

}
