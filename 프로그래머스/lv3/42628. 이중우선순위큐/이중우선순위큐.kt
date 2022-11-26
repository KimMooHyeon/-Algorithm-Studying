import java.util.*

class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf(0,0)
        var maxPq = PriorityQueue<Int>()
        var minPq = PriorityQueue<Int>(reverseOrder())
        operations.forEach{
           val(operation, number) =  it.split(" ")
           when(operation){
                "I" -> {
                   maxPq.add(number.toInt())
                   minPq.add(number.toInt())
               }
               else-> {
                   if(number.toInt() == 1){
                       maxPq.remove(minPq.poll())
                   }else{
                       minPq.remove(maxPq.poll())
                   }
               }
           }
        }
        if(minPq.peek()==null){
             answer[0]=0
            answer[1]=0
        }else{
             answer[0]=minPq.peek()
             answer[1]=maxPq.peek()
        }
        return answer
    }
}