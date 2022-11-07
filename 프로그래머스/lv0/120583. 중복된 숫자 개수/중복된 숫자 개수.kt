class Solution {
    fun solution(array: IntArray, n: Int): Int {
        var answer: Int = 0
        array.forEach{
            if(it == n){
                answer+=1
            }
        }
        return answer
    }
}