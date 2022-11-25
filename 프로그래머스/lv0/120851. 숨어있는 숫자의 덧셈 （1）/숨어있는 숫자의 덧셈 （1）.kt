class Solution {
    fun solution(my_string: String): Int {
        var answer: Int = 0
        my_string.forEach{
            if(it.toString()>="1" && it.toString()<="9"){
                println(it.toString().toInt())
                answer+=it.toString().toInt()
            }
        }
        return answer
    }
}