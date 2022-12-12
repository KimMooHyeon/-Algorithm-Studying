class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        for(i in 1 .. n){
             answer+=1
            while(true){
               if(3.toString() in answer.toString() || answer%3 ==0){
                 answer+=1
               }
                if(3.toString() !in answer.toString() && answer%3 !=0){
                 break
               }
            }
        }
        return answer
    }
}