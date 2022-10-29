import java.util.LinkedList

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = -1
        var num = 0
        val linkedList1 = LinkedList<Int>()
        val linkedList2 = LinkedList<Int>()
        var queue1Sum:Long=queue1.sum().toLong()
        var queue2Sum:Long=queue2.sum().toLong()
        var sum :Long = queue1Sum+queue2Sum
        val halfSum=sum/2
        for (i in queue1.indices){
            linkedList1.add(queue1[i])
            linkedList2.add(queue2[i])
        }
       for (i in 0 .. queue1.size*4){
            if (queue1Sum == queue2Sum){
                return num
            }else if (queue1Sum > queue2Sum){
                val qNum = linkedList1.removeFirst()
                queue2Sum+=qNum
                queue1Sum-=qNum
                linkedList2.addLast(qNum)
                num+=1
            }else{
                val qNum = linkedList2.removeFirst()
                queue2Sum-=qNum
                queue1Sum+=qNum
                linkedList1.addLast(qNum)
                num+=1
            }
       }
        return answer
    }
}