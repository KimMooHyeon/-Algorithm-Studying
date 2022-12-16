class Solution {
    fun solution(num: Int, total: Int): IntArray {
        var answer: IntArray = IntArray(num)
        var nowSum : Int= num*(1+num)/2
        var start :Int = (total-nowSum) / num
        for(i in 1 until num+1){
            answer[i-1]=(i+start)
        }
        return answer
    }
}