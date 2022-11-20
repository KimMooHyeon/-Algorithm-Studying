import java.util.*

data class PrintDocument(
    val priorities : Int,
    val location : Int
)

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        var prioritiesQueue = LinkedList<PrintDocument>().apply{
            for(i in 0 until priorities.size){
                add(PrintDocument(priorities[i],i))
            }
        }
        while(true){
           if (prioritiesQueue.peek().priorities == prioritiesQueue.maxOf{it.priorities}){
                answer+=1
               if(prioritiesQueue.peek().location==location){
                   break
               }
               prioritiesQueue.remove()
           }else{
               prioritiesQueue.add(prioritiesQueue.remove())
           }
        }
        return answer
    }
}