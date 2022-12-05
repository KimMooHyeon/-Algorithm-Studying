import java.util.PriorityQueue

class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer: IntArray = IntArray(score.size)
        val temp = PriorityQueue<Int>()
        score.forEachIndexed{ i,v ->
            if(i<k){
                 temp.add(v)
                 answer[i]=temp.peek()
            }else{
                if(v>temp.peek()){
                    temp.poll()
                    temp.add(v)
                    answer[i]=temp.peek()
                }else{
                     answer[i]=temp.peek()
                }
            }
        }

        return answer
    }
}