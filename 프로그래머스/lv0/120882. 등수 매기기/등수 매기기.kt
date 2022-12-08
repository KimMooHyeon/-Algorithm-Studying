class Solution {
    fun solution(score: Array<IntArray>): IntArray {
        var answer: IntArray = IntArray(score.size){1}
        val temp = score.map{
   
                 (it[0].toFloat()+it[1].toFloat())/2
            
        }
        temp.forEach{
            temp.forEachIndexed{ i,v->
                if(it.toFloat()>v.toFloat()){
                    answer[i]++
                }
            }
        }
        return answer
    }
}