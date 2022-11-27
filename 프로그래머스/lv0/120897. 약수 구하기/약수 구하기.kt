class Solution {
    fun solution(n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var answerList  =mutableListOf<Int>()
        for(i in 1 .. n){
            if(n%i ==0){
                answerList.add(i)
            }
        }
        return answerList.toIntArray()
    }
}