class Solution {
    fun solution(my_string: String, n: Int): String {
        var answer: String = ""
        my_string.forEach{
            for(i in 1 .. n){
                answer+=it
            }
        }
        return answer
    }
}