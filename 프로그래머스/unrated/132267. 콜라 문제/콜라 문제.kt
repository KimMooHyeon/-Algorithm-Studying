class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var recent_n = n
        var newCoke = 0
        
        while(true){
            if(recent_n<a){
                break
            }

            var num = recent_n/a
            answer += num*b
            // 11 5 3
            // 7 5 3
            // 5 5 3
            // 0 5 3
            recent_n -= a*num
            recent_n += num*b
        }
        
        return answer
    }
}