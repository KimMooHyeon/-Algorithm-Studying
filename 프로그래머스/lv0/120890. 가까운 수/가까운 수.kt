import kotlin.math.*
class Solution {
    fun solution(array: IntArray, n: Int): Int {
        var answer: Int = 0
        var minNum = n 
        array.sort()
        array.forEach{
            if(minNum>abs(it-n)){
                minNum =abs(it-n)
                answer=it
            }
        }
        return answer
    }
}