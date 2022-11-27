class Solution {
    fun solution(order: Int): Int {
        var answer: Int = 0
        order.toString().forEach{
            if((it.toString().toInt()%3)==0 && it.toString() != "0"){
                answer+=1
            }
        }
        return answer
    }
}