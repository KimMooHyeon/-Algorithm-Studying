import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.TreeSet


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()

    var numList = IntArray(21)

    for (i in 1..N) {
        val input = br.readLine().split(" ")
        when (input[0]) {
            "add" -> {
                numList[input[1].toInt()] = 1
            }
            "remove" -> {
                numList[input[1].toInt()] = 0
            }
            "check" -> {
                if (numList[input[1].toInt()] == 1) {
                    bw.write("1\n")
                } else {
                    bw.write("0\n")
                }
            }
            "toggle" -> {
                if (numList[input[1].toInt()] == 1) {
                    numList[input[1].toInt()] = 0
                } else {
                    numList[input[1].toInt()] = 1
                }
            }
            "all" -> {
                numList = IntArray(21) { 1 }
            }
            "empty" -> {
                numList = IntArray(21)
            }
        }
    }

    br.close()
    bw.close()

}
