import java.util.*

class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = 200000000
        val stoneQueue = LinkedList<Int>()
        var nowMaxNum: Int = 0
        if(stones[0]<stones[stones.size-1]){
           stones.forEachIndexed { i, v ->
            if (stoneQueue.size < k) {
                if (nowMaxNum < v) {
                    nowMaxNum = v
                }
                stoneQueue.add(v)
                if(stoneQueue.size == k){
                     stoneQueue.maxOrNull()?.let {
                        nowMaxNum = it
                        answer =it
                    }
                }
            }else {
                if (nowMaxNum == stoneQueue.poll()) {
                    stoneQueue.add(v)
                    stoneQueue.maxOrNull()?.let {
                        nowMaxNum = it
                    }
                    if (answer > nowMaxNum) {
                        answer = nowMaxNum
                    }
                } else {
                    if (answer > nowMaxNum) {
                        answer = nowMaxNum
                    }
                    stoneQueue.add(v)
                }
            }
         }
        }else{
            for(i in stones.size-1 downTo 0 ) { 
            if (stoneQueue.size < k) {
                if (nowMaxNum < stones[i]) {
                    nowMaxNum = stones[i]
                }
                stoneQueue.add(stones[i])
                if(stoneQueue.size == k){
                     stoneQueue.maxOrNull()?.let {
                        nowMaxNum = it
                        answer =it
                    }
                }
            }else {
                if (nowMaxNum == stoneQueue.poll()) {
                    stoneQueue.add(stones[i])
                    stoneQueue.maxOrNull()?.let {
                        nowMaxNum = it
                    }
                    if (answer > nowMaxNum) {
                        answer = nowMaxNum
                    }
                } else {
                    if (answer > nowMaxNum) {
                        answer = nowMaxNum
                    }
                    stoneQueue.add(stones[i])
                }
            }
         }
        }
       
        var maxCheck =0
        for(i in stones.size-k .. stones.size-1){
            if(maxCheck <stones[i]){
                maxCheck=stones[i]
            }
        }
        if(answer > maxCheck){
            answer= maxCheck
        }
        return answer
    }
}