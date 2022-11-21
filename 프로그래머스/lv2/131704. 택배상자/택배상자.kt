import java.util.*

class Solution {
    fun solution(order: IntArray): Int {
        var answer: Int = 0
        var orderIndex = 0
        val containerStack = Stack<Int>()
// 1 2 3 
        for(i in 1 .. order.size){
            if(order[orderIndex]>i){
               containerStack.add(i) 
            }else if (order[orderIndex]==i){
                answer+=1
                orderIndex+=1
                if(orderIndex>=order.size){
                    break
                }
                var checkFlag =false
                while(true){
                    if(containerStack.isEmpty()){
                        break
                    }
                      if(orderIndex>=order.size){
                          break
                     }
                    if(containerStack.peek() == order[orderIndex]){
                        answer+=1
                        orderIndex+=1
                        containerStack.pop()
                    }else if(containerStack.peek() > order[orderIndex]){
                        checkFlag=true
                        break
                    }else{
                        break
                    }
                }
                if(checkFlag){
                    break
                }
            }
        }
        return answer
    }
}