import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.TreeSet

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val input = br.readLine().toString()
        if (input == "0 0 0") {
            break
        } else {
            val inputList = input.split(" ").map { it.toInt() }.sorted()
            if ((inputList[0] * inputList[0] + inputList[1] * inputList[1]) == inputList[2] * inputList[2]) {
                bw.write("right\n")
            } else {
                bw.write("wrong\n")
            }
        }
    }
    bw.close()
}