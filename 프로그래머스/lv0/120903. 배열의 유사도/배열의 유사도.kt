class Solution {
    fun solution(s1: Array<String>, s2: Array<String>): Int {
        var answer: Int = 0
        s1.forEach{
            if(it in s2){
                answer+=1
            }
        }
        return answer
    }
}