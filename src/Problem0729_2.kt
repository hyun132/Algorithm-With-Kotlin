class Solution {
    
    val map = hashMapOf<String,Int>(
        "cpp" to 1, "backend" to 1, "junior" to 1,"chicken" to 1,
        "java" to 2, "frontend" to 2, "senior" to 2, "pizza" to 2,
        "python" to 4, "-" to 7
    )
    
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer: IntArray = IntArray(query.size)
        val infoArr = Array(info.size){Array<Int>(5){0}}
        val infoMap = hashMapOf<String,ArrayList<Int>>()
        for(i in 0 until info.size){
            val person = info[i].split(" ").mapIndexed{ idx, item->
                if(idx==4) item.toInt()
                else (map[item]?:0)
            }
         
            (infoMap.getOrPut(person.slice(0..3).joinToString("")){arrayListOf()}).add(person[4].toInt())
        }
        for(p in infoMap.values){
            p.sort()
        }
        for(i in 0 until query.size){
            val q=query[i]
            val splited = q.replace(" and","").split(" ")
            val queryArr = splited.mapIndexed{ idx, item->
                if(idx==4) item.toInt()
                else (map[item]?:0)
            }

            for(p in infoMap.keys){
                var count = 0 
                for(idx in 0 until 4) {
                    if(queryArr[idx].and(p[idx].toInt()) > 0) count++ else break
                }
                if(count==4){
                    val arr = (infoMap[p]?: arrayListOf<Int>())
                    answer[i] += (arr.size - binarySearch(arr,queryArr[4]))
                } 
            }
        }
        
        return answer
    }
    
    fun binarySearch(arr:ArrayList<Int>,target:Int):Int{
        var l = 0
        var r = arr.size-1
        var m = (l+r)/2
        
        while(l<=r){
            m = (l+r)/2
            if(arr[m]>=target){
                r=m-1
            } else{
                l=m+1
            }
        }
        return r+1;
    }
}
