class Solution {
    fun solution(n: Int): IntArray {
        var answer = mutableListOf<Int>()
        for(i in 1 .. n){
            if(i%2 == 1){
                answer.add(i)
            }
        }
        return answer.toIntArray()
    }
}