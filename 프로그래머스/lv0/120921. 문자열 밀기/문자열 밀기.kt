import java.util.*
class Solution {
    fun solution(A: String, B: String): Int {
        var answer: Int = -1
        val aQueue = LinkedList<Char>()
        val bQueue = LinkedList<Char>()
        for(i in 0 until B.length){
              bQueue.add(B[i])
        }
        for(i in 0 until A.length){
              aQueue.add(A[i])
        }
        for(i in 0 .. A.length){
            if(aQueue == bQueue){
                return i
            }else{
                aQueue.addFirst(aQueue.removeLast())
            }
        }
        return answer
    }
}