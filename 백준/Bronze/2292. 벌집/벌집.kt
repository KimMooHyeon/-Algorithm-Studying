import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var destination = br.readLine().toInt()
    var num = 1
    var index = 1
    var answer = 1
    while (num < destination) {
        num += 6 * index
        index += 1
        answer+=1
    }
    println(answer)

    br.close()
    bw.close()
}
