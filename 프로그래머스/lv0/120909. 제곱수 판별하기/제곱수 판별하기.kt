import kotlin.math.*

class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 2
       for(i in sqrt(n.toDouble()).toInt()-1 .. sqrt(n.toDouble()).toInt()+1){
           if((i*i)==n){
               answer-=1
           }
       }
       return answer
}
}