class Solution {
    fun solution(dot: IntArray): Int {
        var answer: Int = 0
        val x = dot[0]
        val y = dot[1]
        if(x>0){
            if(y>0){
                return 1
            }else{
                return 4
            }
        }else{
              if(y>0){
                return 2
            }else{
                return 3
            }
        }
        return answer
    }
}