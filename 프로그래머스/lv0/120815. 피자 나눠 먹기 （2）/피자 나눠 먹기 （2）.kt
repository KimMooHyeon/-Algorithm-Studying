class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        for (i in 1 .. 600){
            if( (6*i)%n ==0 ){
                return i
            }
        }
        return 1
    }
}