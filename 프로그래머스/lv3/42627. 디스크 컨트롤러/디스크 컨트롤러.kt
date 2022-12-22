import java.util.*

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        jobs.sortWith(compareBy({it[1]},{it[0]}))
        val mainPq = PriorityQueue<IntArray>(compareBy({it[0]},{it[1]}))
        mainPq.addAll(jobs)
        val beforePq = PriorityQueue<IntArray>(compareBy({it[1]}))
        var answer = 0
        var time = 0

        while(mainPq.isNotEmpty() || beforePq.isNotEmpty()){   
            while(mainPq.isNotEmpty()){
                if(time>=mainPq.peek()[0]){
                    beforePq.add(mainPq.poll())
                }else{
                    break
                }
            }
            if(beforePq.isNotEmpty()){
                val v = beforePq.poll()
                  answer+=time-v[0]+v[1]
                  time+=v[1]
            }else{
                time++
            }
        }
        return answer/jobs.size
    }
}