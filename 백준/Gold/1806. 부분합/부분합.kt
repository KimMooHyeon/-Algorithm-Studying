import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val temp = br.readLine().split(" ").map { it.toInt() }
    var answer = Int.MAX_VALUE
    var left = 0
    var right = 0
    var sumList = temp[0]
    while (right < n) {
      //  println("$left $right $sumList")
        if (sumList >= s) {
            answer = minOf(answer, right - left + 1)
            if (left == right) {
                left += 1
                right += 1
                if (right >= n) {
                    break
                }
                sumList += temp[right]
            } else if (left + 1 == right) {
                sumList -= temp[left]
                left += 1
            } else {
                sumList -= temp[left]
                left += 1
            }
        } else if (sumList < s) {
            right += 1
            if (right >= n) {
                break
            }
            sumList += temp[right]
        }
    }
    if (answer == Int.MAX_VALUE) {
        println(0)
    } else {
        println(answer)
    }

    bw.close()
    br.close()
}
