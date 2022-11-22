class Solution {
    fun solution(strlist: Array<String>): IntArray {
        var answer = Array(strlist.size){0}
        strlist.forEachIndexed{ i,v ->
            answer[i] = v.length
        }
        return answer.toIntArray()
    }
}