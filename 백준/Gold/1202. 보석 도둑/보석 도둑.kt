import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

data class Jewelry(val weight: Long = 0, val price: Long = 0) : Comparable<Jewelry> {
    override fun compareTo(other: Jewelry) = (other.price - price).toInt()
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val bag = mutableListOf<Long>()
    val jewelryAllList = mutableListOf<Jewelry>()
    val jewelryQueue = PriorityQueue<Jewelry>()

    // 보석의 정보
    repeat(n) {
        val (m, v) = br.readLine().split(" ").map { it.toLong() }
        jewelryAllList.add(Jewelry(m, v))
    }
    jewelryAllList.sortWith(compareBy { it.weight })
    repeat(k) {
        val c = br.readLine().toLong()
        bag.add(c)
    }
    var answer = 0L
    var jewelryCheck = 0L
    var jewelryIndex = 0
    bag.sort()
    for (i in 0 until bag.size) {

        while (jewelryIndex < n && jewelryAllList[jewelryIndex].weight <= bag[i]) {
            jewelryQueue.add(jewelryAllList[jewelryIndex])
            jewelryIndex += 1
        }
        if (jewelryQueue.isNotEmpty()){
            answer+=jewelryQueue.poll().price
            jewelryCheck+=1
        }

    }

    // jewelry는 가격이 비싼 순으로
    // 가방은 무게가 낮은 순으로

    println(answer)
    br.close()
    bw.close()
}