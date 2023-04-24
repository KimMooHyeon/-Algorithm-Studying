import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs
import kotlin.math.round

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val nList = mutableListOf<Pair<Int, Int>>()
    var answer: Long = 0
    repeat(n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        nList.add(Pair(temp[0], temp[1]))
    }
    //nList.sortedBy { it.second }
    nList.add(nList[0])
    var plus: Long = 0
    var minus: Long = 0
    for (i in 0 until nList.lastIndex) {
        plus += (nList[i].first.toLong() * nList[i + 1].second.toLong())
        minus -= (nList[i].second.toLong() * nList[i + 1].first.toLong())
    }

    if (minus>0){
        minus=-minus
        answer = abs(plus - minus)
    }else{
        answer = abs(plus + minus)
    }

    System.out.printf("%.1f", answer / 2.0)
    bw.close()
    br.close()
}
