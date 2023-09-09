package leetcode.tryeasyproblem

import delivery.Solution
import org.w3c.dom.css.Counter

class Seesaw_mate {
//    fun solution(weights: IntArray): Long {
//        var answer: Long = 0
//
//        var l = 0
//        var r = 0
//        var value=0
//        var m =0
//        var arr = arrayListOf(1,4/3,3/2,2)
//        arr.sort()
//        var cnt = 0
//        for(i in 0 until weights.size){
//            if(i!=0 && weights[i] == weights[i-1]){
//                --cnt
//                answer += cnt
//                continue
//            }
//            l = i + 1
//            cnt =0
//            for (target in arr) {
//                r = weights.size - 1
//                l = i + 1
//                value = weights[i]
//                while (l < r) {
//                    m=(l+r)/2
//                    if(value * target == weights[m] || value* target== weights[m] || value *target == weights[m] || value == weights[l]) {
//                        cnt+=1
//                        break
//                    }
//                    else if(value *target > weights[m]){
//                        r=m
//                    }else if(value*target<= weights[m]){
//                        l=m+1
//                    }
//                }
//            }
//            answer+=cnt
//        }
//        return answer
//    }


    fun solution(weights: IntArray): Long {
        var answer: Long = 0
        val map = mutableMapOf<Double, Int>()

        var n =1.0
        for (w in weights) {
            n=w*1.0
            if (map.containsKey(n)) {
                map[n] = map[n]!! + 1
            } else {
                map[n] = 1
            }
        }
        var target = 0
        weights.sort()
        for (w in weights) {
            map[w.toDouble()] = map[w.toDouble()]!!-1
            if (map.containsKey(w.toDouble())) answer += map[w.toDouble()]!!
            if (map.containsKey(w*2.0)) answer += map[w*2.0]!!
            if (map.containsKey(w*4/3.0)) answer += map[w*4/3.0]!!
            if (map.containsKey(w*3/2.0)) answer += map[w*3/2.0]!!
        }
        return answer
    }
}

fun main() {
    val arr = intArrayOf(100, 180, 360, 100, 270)
    val sol = Seesaw_mate()
    print(sol.solution(arr))
}