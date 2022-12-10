import java.util.*

import kotlin.math.abs

class Solution {
    fun solution(numlist: IntArray, n: Int): IntArray {
        var answer: IntArray = IntArray(numlist.size)
       
        var pq = numlist.sortedWith(compareBy({abs(it-n)},{-it}))
        pq.forEachIndexed{ i,v->
           answer[i]=v
          //  println(v)
        }
        return answer
    }
}