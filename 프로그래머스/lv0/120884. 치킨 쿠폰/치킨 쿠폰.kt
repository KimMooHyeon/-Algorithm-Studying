class Solution {
    fun solution(chicken: Int): Int {
        var answer: Int = 0
        var chickenNum = chicken
        var coupon = 0
        while(chickenNum>10){
            var num =chickenNum/10
            answer+=num
            chickenNum%=10
            chickenNum+=num
        }
        if(chickenNum==10){
            answer+=1
        }
        return answer
    }
}