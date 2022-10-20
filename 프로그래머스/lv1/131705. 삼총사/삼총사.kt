class Solution {
    fun solution(number: IntArray): Int {
        var answer: Int = 0
        
        for(first in 0 until number.size-2){
            for (second in first+1 until number.size-1){
                for(third in second+1 until number.size){
                    if(number[first]+number[second]+number[third] == 0){
                        answer+=1
                    }
                }
            }
        }
        
        return answer
    }
    
}