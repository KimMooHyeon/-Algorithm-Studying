class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var sum =1
        for(i in 1 ..n){
            if(n<sum*i){
                answer = i-1
                break
            }else{
                 sum*=i
            }
        }
        if(n==1){
            answer=1
        }else if(n==2){
            answer=2
        }
        return answer
    }
}