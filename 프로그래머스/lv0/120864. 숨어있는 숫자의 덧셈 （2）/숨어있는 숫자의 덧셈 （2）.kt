class Solution {
    fun solution(my_string: String): Int {
        var answer: Int = 0
        var digit = ""
        my_string.forEach{
            if(it.isDigit()){
                digit+=it.toString()
               
            }else{
                if(digit != ""){
                     answer+=digit.toInt()
                     digit=""
                }
            }
        }
         if(digit != ""){
                     answer+=digit.toInt()
                     digit=""
                }
        return answer
    }
}