class Solution {
    fun solution(my_string: String): String {
        var answer: String = ""
        val wordList = mutableListOf<String>()
        my_string.forEach{
            if(it.toString() !in wordList){
                answer+=it.toString()
                wordList.add(it.toString())
            }
        }
        return answer
    }
}