class Solution {
    fun solution(num: Int, k: Int): Int {
        var answer: Int = 0
        answer = num.toString().toMutableList().map { it.toString() }.indexOf(k.toString())
        if(answer!=-1){
            answer+=1
        }
        return answer
    }
}