import java.util.*
class Solution {
    fun checkBuger(burgerStack : Stack<Int>):Boolean{
        if(burgerStack[burgerStack.size-1]==1 &&
           burgerStack[burgerStack.size-2]==3 &&
            burgerStack[burgerStack.size-3]==2 &&
            burgerStack[burgerStack.size-4]==1){
            return true
        }else{
            return false
        }
    }
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        val burgerStack = Stack<Int>()

        ingredient.forEach{
            if(burgerStack.size<4){
                burgerStack.push(it)
            }else{
                burgerStack.push(it)
                if(checkBuger(burgerStack)){
                    answer+=1
                    repeat(4){
                          burgerStack.pop()
                    }
                }
            }
        }
        if(burgerStack.size>=4){
              if(checkBuger(burgerStack)){
                    answer+=1
                    repeat(4){
                          burgerStack.pop()
                    }
                }
        }
        return answer
    }
}
