class Solution {
    fun solution(array: IntArray, height: Int): Int {
        var answer: Int = 0
        for(i in array){
            if(height<i){
                answer+=1
            }
        }
        return answer
    }
}