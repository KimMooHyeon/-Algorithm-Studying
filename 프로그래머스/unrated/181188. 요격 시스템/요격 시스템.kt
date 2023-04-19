class Solution {
    fun solution(targets: Array<IntArray>): Int {
        targets.sortWith(compareBy{it[1]})
        var answer: Int = 1
      
        var end = targets[0][1]
        for(i in 1 .. targets.lastIndex){
            if(targets[i][0]>=end){
                end=targets[i][1]
                answer+=1
            }
            
        }
   

        return answer
    }
}