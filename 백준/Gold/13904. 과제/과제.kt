import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

data class Study(var day: Int, val score: Int) : Comparable<Study> {
    override fun compareTo(other: Study): Int {
        return this.score - other.score
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val studyList = mutableListOf<Study>()
    repeat(n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        studyList.add(Study(temp[0], temp[1]))
    }
    val queue = PriorityQueue<Study>()
    studyList.sortWith(compareBy { it.day })
    var day = 1
   // println(studyList)
    studyList.forEach {
        if (day > it.day) {
            if (queue.isNotEmpty()) {
                if (queue.peek().score < it.score) {
                    queue.poll()
                    queue.add(it)
                }
            }
        } else {
            queue.add(it)
            day += 1
        }

    }
    var answer = 0L
   // println(queue)
    while (queue.isNotEmpty()) {
        answer += (queue.poll().score)
    }
    println(answer)
    bw.close()
}

