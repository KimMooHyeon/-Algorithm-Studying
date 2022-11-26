class Solution {
    fun solution(my_string: String): String {
        var answer: String = ""
        my_string.forEach{
            if(it.isUpperCase()){
                answer+=it.toString().lowercase()
            }else{
                answer+=it.toString().uppercase()
            }
        }
        return answer
    }
}