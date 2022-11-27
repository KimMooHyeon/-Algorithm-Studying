class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        for(i in 1 .. n){
            if(measure(i)){
                answer+=1
            }
        }
        return answer
    }
    fun measure(n : Int):Boolean{
        var num =0
        for(i in 1.. n-1){
            if(n%i == 0){
                num+=2
            }
            if(num>2){
                return true
            }
        }
        return false
    }

}