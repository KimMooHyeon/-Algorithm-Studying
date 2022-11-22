class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var startNum = n
        repeat(n.toString().length){
            answer+= startNum%10
            startNum/=10
        }
        return answer
    }
}