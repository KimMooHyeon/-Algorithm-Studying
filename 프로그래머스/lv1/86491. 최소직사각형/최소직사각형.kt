import java.util.*
class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0
        var first = PriorityQueue<Int>()
        var second = PriorityQueue<Int>()
        sizes.forEach{
            if(it[0]>it[1]){
                first.add(-it[0])
                second.add(-it[1])
            }else{
                first.add(-it[1])
                second.add(-it[0])
            }
        }
        return first.poll() * second.poll()
    }
}