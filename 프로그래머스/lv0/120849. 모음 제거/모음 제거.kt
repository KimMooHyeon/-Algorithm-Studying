class Solution {
    fun solution(my_string: String): String {
        var answer: String = my_string.replace("i","").replace("o","").replace("e","").replace("u","").replace("a","")
        return answer
    }
}