class Solution {
    fun solution(str1: String, str2: String): String {
        var answer: String = ""
        str1.forEachIndexed{i,v ->
            answer+="${v}${str2[i]}"
        }
        return answer
    }
}