package leetcode.tryeasyproblem

class Discount_event {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0

        val cart = HashMap<String,Int>()

        number.zip(want){ n,item->
            cart.putIfAbsent(item,n)
        }
        val size = discount.size
        val discount = discount + Array(10){"empty"}

        var l = -1
        var r = 0

        discount.forEachIndexed { index, s ->
            l = kotlin.math.max(index-10,0)
            if(l==size) return@forEachIndexed
            r = index

            if(index>=10 && cart.containsKey(discount[l])) cart[discount[l]] = cart[discount[l]]!!+1
            if(cart.containsKey(discount[r])) cart[discount[r]] = cart[discount[r]]!!-1
            r+=1

            if(cart.values.sum() == 0) {
                if(cart.values.filter{ it>=0 }.size == cart.size){
                    answer += 1
                }
            }
        }
        return answer
    }
}

fun main() {

    val dis = Discount_event()
    println(dis.solution(arrayOf("banana", "apple", "rice", "pork", "pot"), intArrayOf(3, 2, 2, 2, 1), arrayOf("chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana")))
//    println(dis.solution(arrayOf( "apple"), intArrayOf(10), arrayOf("banana",  "banana",  "banana",  "banana",  "banana",  "banana",  "banana",  "banana",  "banana",  "banana")))
}