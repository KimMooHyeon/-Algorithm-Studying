import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

data class Answer(var start: Long, var left: Long, var right: Long) {
    override fun toString(): String {
        return "$start $left $right"
    }
}

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var answer: Long = Long.MAX_VALUE
    val answerList = Answer(0, 0, 0)
    val n = br.readLine().toInt()
    val _nList = br.readLine().split(" ").map { it.toLong() }
    val nList = _nList.sorted()

    for (start in 0 until nList.lastIndex - 1) {
        var left = start + 1
        var right = nList.lastIndex
        while (left < right) {
            val inSum = nList[left] + nList[right]
            if (inSum + nList[start] == 0L) {
                answer = abs(inSum + nList[start])
                answerList.start = nList[start]
                answerList.left = nList[left]
                answerList.right = nList[right]
                break
            } else {
                if (answer > abs(inSum + nList[start])) {
                    answer = abs(inSum + nList[start])
                    answerList.start = nList[start]
                    answerList.left = nList[left]
                    answerList.right = nList[right]
                }
                if (inSum + nList[start] > 0L) {
                    right -= 1
                } else {
                    left += 1
                }
            }
        }
    }

    println(answerList)
    br.close()
    bw.close()
}
