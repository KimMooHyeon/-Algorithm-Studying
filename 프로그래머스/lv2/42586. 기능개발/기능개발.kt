import java.util.*

data class Progress(
   var progress : Int,
   val speed : Int 
)

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): ArrayList<Int> {
        var answer = arrayListOf<Int>()
        val progresseSize = progresses.size
        val finishQueue = LinkedList<Progress>()
        val progressQueue = LinkedList<Progress>().apply{
            for(i in 0 until progresses.size){
                add(Progress(progresses[i],speeds[i]))
            }
        }
        while(answer.sum()<progresseSize){
            progressQueue.forEach{
                it.progress += it.speed
            }
            var finishNum=0
            while(true){
               if(progressQueue.peek() == null){
                   break
               }
              if(progressQueue.peek().progress>=100){
                finishNum+=1
                progressQueue.remove()
               }else{
                  break
              }
            }
            if(finishNum != 0 ){
                answer.add(finishNum)
                finishNum=0
            }
        }
        return answer
    }
}