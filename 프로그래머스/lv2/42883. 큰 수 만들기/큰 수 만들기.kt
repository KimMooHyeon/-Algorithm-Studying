import java.util.*
class Solution {
    fun solution(number: String, k: Int): String {
        var kNum = k
        val numStack = Stack<Int>()
        for(i in 0 until number.length){
            if(k == 0){
                break
            }
            if(numStack.isEmpty()){
                numStack.add(number[i].toString().toInt())
            }else{
                val num = number[i].toString().toInt()
                if(numStack.peek()<num){
                    while(numStack.isNotEmpty()){
                         if(numStack.peek()>=num || kNum<=0){
                            break
                         }
                         numStack.pop()
                         kNum-=1
                    }
                }
                numStack.add(num)   
            }
        }
        return numStack.joinToString("").substring(0,number.length-k)
    }
}