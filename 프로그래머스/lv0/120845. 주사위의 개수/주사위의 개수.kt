class Solution {
    fun solution(box: IntArray, n: Int): Int {
        var answer: Int = 1
        box.forEach{
            answer*= it/n
        }
        return answer
    }
}