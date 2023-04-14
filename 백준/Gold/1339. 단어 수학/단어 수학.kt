import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

data class Alpha(val alpha: Char, val value: Int) : Comparable<Alpha> {
    override fun compareTo(other: Alpha) = other.value - value
}

fun returnNum(num: Int): Int {
    var numSum = 1
    repeat(num - 1) {
        numSum *= 10
    }
    return numSum
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val alpha = mutableListOf<String>()
    var answer = 0
    var index = 9
    // legth에 대한 알파벳 수
    val hash = HashMap<Char, Int>()
    repeat(n) {
        val addString = br.readLine().toString()
        val length = addString.length
        for (i in 0..addString.lastIndex) {
            if (addString[i] in hash) {
                hash[addString[i]] = hash[addString[i]]!! + returnNum(length - i)
            } else {
                hash[addString[i]] = returnNum(length - i)
            }
        }
        alpha.add(addString)
    }
    val alphaList = PriorityQueue<Alpha>()
    hash.forEach {
        alphaList.add(Alpha(it.key, it.value))
    }
    while (alphaList.isNotEmpty()) {
        val myAlpha = alphaList.poll()
        answer+=(myAlpha.value*index--)
    }
    println(answer)
    br.close()
    bw.close()
}