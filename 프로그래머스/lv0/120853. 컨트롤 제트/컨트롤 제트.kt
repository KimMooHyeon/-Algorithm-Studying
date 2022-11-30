import java.util.*

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        val sList =s.split(" ")
        val stackTemp = Stack<Int>()
        sList.forEach{
            if(it.toString() == "Z"){
                stackTemp.pop()
            }else{
                stackTemp.push(it.toString().toInt())
            }
        }
        while(stackTemp.isNotEmpty()){
            answer+=stackTemp.pop()
        }
        return answer
    }
}