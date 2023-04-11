class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = IntArray(2)
        var start = 0
        var smallSize = Int.MAX_VALUE
        var end = start
        var sum = sequence[0]
        val sequenceSize =sequence.size
        while(end<sequenceSize && start<sequenceSize){
          //  println("$start $end $sum")
            if(sum == k){
              //  println("찾음 $start $end ${end-start}")
                if(end-start<smallSize){
                    smallSize = end-start
                    answer[0]=start
                    answer[1]=end
                }
                sum-=sequence[start]
                start+=1  
            }
            if(sum<k){
                end+=1
               if (end<sequenceSize){
                   sum+=sequence[end]
               }    
            }else{
                sum-=sequence[start]
                start+=1
            }
            if(sum == k){
              //  println("찾음 $start $end ${end-start}")
                if(end-start<smallSize){
                    smallSize = end-start
                    answer[0]=start
                    answer[1]=end
                }
                sum-=sequence[start]
                start+=1  
            }
        }
        return answer
    }
}