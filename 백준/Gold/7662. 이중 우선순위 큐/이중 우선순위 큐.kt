import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

class DualPriorityQueue() {
    // 정수 자체를 우선순위
    var maxQueue = PriorityQueue<Long>()
    var minQueue = PriorityQueue<Long>()
    private val numHash = HashMap<Long, Long>()
    fun add(num: Long) {
        if (num in numHash) {
            numHash[num] = numHash[num]!! + 1
        } else {
            numHash[num] = 1
        }
        maxQueue.add(-num)
        minQueue.add(num)
    }

    fun popMin() {

        if (minQueue.isEmpty()) {
            return
        }
        val num = minQueue.poll()
        if (num in numHash) {
            if (numHash[num]!! > 0) {
                numHash[num] = numHash[num]!! - 1
            } else {
                popMin()
            }
        }
    }

    fun popMax() {
        if (maxQueue.isEmpty()) return
        val num = -(maxQueue.poll())
        if (num in numHash) {
            if (numHash[num]!! > 0) {
                numHash[num] = numHash[num]!! - 1
            } else {
                popMax()
            }
        }
    }

    fun getMinNum(): Pair<Long, Boolean> {
        while (minQueue.isNotEmpty()) {
            val curQueue = minQueue.peek()
            if (curQueue in numHash) {
                if (numHash[curQueue]!! > 0) {
                    return Pair(curQueue, true)
                }else{
                    minQueue.poll()
                }
            }
        }
        return Pair(0, false)
    }

    fun getMaxNum(): Pair<Long, Boolean> {
        while (maxQueue.isNotEmpty()) {
            val curQueue = -(maxQueue.peek())
            if (curQueue in numHash) {
                if (numHash[curQueue]!! > 0) {
                    return Pair(curQueue, true)
                }else{
                    maxQueue.poll()
                }
            }
        }
        return Pair(0, false)
    }
    fun print(){
        println(numHash)
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()
    //val (n, m) = br.readLine().split(" ").map { it.toInt() }
    repeat(tc){
        val k = br.readLine().toInt()
        val dualPriorityQueue = DualPriorityQueue()

        repeat(k){
            val (n, m) = br.readLine().split(" ")
            when(n){
                "I"->{
                    // 삽입
                    dualPriorityQueue.add(m.toLong())
                }
                "D"->{
                    //1는 최대값 삭제
                    // -1 최소값 삭제
                    if (m =="1"){
                        dualPriorityQueue.popMax()
                    }else{
                        dualPriorityQueue.popMin()
                    }
                }
            }
        }
        if (dualPriorityQueue.getMaxNum().second && dualPriorityQueue.getMinNum().second){
            println("${dualPriorityQueue.getMaxNum().first} ${dualPriorityQueue.getMinNum().first}")
        }else{
            println("EMPTY")
        }
    }


    br.close()
}
