class Solution {
    fun solution(i: Int, j: Int, k: Int): Int {
        var answer: Int = 0
        for(index in i .. j){
            if(k.toString() in index.toString()){
                println(index.toString())
                index.toString().forEach{
                    if(it.toString() ==k.toString()){
                          answer+=1
                    }
                } 
            }
        }
        return answer
    }
}