import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var size = 0
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val hash = HashMap<String, Int>()
    val temp = br.readLine().split(" ")
    when (temp[1]) {
        "Y" -> {
            size = 1
        }
        "F" -> {
            size = 2
        }
        "O" -> {
            size = 3
        }
    }
    var num = 0
    var answer = 0
    repeat(temp[0].toInt()) {
        val text = br.readLine()
        if (text !in hash) {
            num += 1
            hash[text!!] = 1
        }
        if (size == num) {
            answer += 1
            num = 0
        }
    }
    println(answer)
    br.close()
    bw.close()
}
