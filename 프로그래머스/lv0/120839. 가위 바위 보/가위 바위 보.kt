class Solution {
    fun solution(rsp: String): String {
        var answer: String = ""
        val hs = mapOf<String,String>("2" to "0" , "0" to "5", "5" to "2")
        rsp.forEach{
            answer+=hs[it.toString()]
        }
        return answer
    }
}