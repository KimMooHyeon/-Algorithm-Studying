class Solution {
    fun solution(arr: IntArray): Double {
        var answer = 0.0
        var sum=0.0
        for(i in arr){
            sum+=i
        }
        answer = sum/(arr.size)
        return answer
    }
}