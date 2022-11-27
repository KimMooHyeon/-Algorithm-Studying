class Solution {
    fun solution(array: IntArray): IntArray {
        var answer: IntArray = intArrayOf(0,0)
        array.maxOrNull()?.let{
            answer[0]=it
            answer[1]=array.indexOf(it)
        }
        return answer
    }
}