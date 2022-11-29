class Solution {
    fun solution(array: IntArray): Int {
        var answer: Int = 0
        array.forEach{
            it.toString().forEach{ v->
                if(v.toString() =="7"){
                    answer+=1
                }              
            }
        }
        return answer
    }
}