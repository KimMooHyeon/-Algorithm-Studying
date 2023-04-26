import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

data class Answer(var left: Long, var right: Long) {
    override fun toString(): String {
        return "$left $right"
    }
}

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var answer: Long = Long.MAX_VALUE
    val answerList = Answer(0L, 0L)
    val n = br.readLine().toInt()
    val nList = br.readLine().split(" ").map { it.toLong() }
    var left = 0
    var right = nList.lastIndex
    while (left < right) {
        if (nList[left] + nList[right] == 0L) {
            answerList.left = nList[left]
            answerList.right = nList[right]
            break
        } else if (nList[left] + nList[right] > 0L) {
            if (answer >= abs(nList[left] + nList[right])) {
                answer = abs(nList[left] + nList[right])
                answerList.left = nList[left]
                answerList.right = nList[right]
            }
            right -= 1
        } else {
            if (answer >= abs(nList[left] + nList[right])) {
                answer = abs(nList[left] + nList[right])
                answerList.left = nList[left]
                answerList.right = nList[right]
            }
            left += 1
        }
    }
    println(answerList)
    br.close()
    bw.close()
}
