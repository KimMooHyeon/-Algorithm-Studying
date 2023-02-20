import java.util.*
class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var answer: String = ""
        val card1Queue = LinkedList<String>()
        cards1.forEach{
            card1Queue.add(it)
        }
        val card2Queue = LinkedList<String>()
        cards2.forEach{
            card2Queue.add(it)
        }
        val goalQueue = LinkedList<String>()
        goal.forEach{
            goalQueue.add(it)
        }
        var cards1Flag = false
        var cards2Flag = false 
        while(goalQueue.isNotEmpty()){
            if(card1Queue.isNotEmpty()){
                if(goalQueue.peek()==card1Queue.peek()){
                    goalQueue.pop()
                    card1Queue.pop()
                    cards1Flag=false
                }else{
                 cards1Flag=true
                 }
            }else{
                cards1Flag=true
            }
             if(card2Queue.isNotEmpty()){
                if(goalQueue.peek()==card2Queue.peek()){
                    goalQueue.pop()
                    card2Queue.pop()
                    cards2Flag=false
                }else{
                    cards2Flag=true
                }
            }else{
                cards2Flag=true
            }
             if(cards2Flag && cards1Flag){
                 break
             }
        }
        if(goalQueue.isEmpty()){
            answer ="Yes"
        }else{
            answer ="No"
        }
        return answer
    }
}