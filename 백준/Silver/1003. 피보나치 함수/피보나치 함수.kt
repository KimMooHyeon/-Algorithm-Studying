import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.TreeSet

var oneCount = 0
var zeroCount = 0

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()

    for (i in 1..N) {
        val n = br.readLine().toInt()
        var zeroNumList = IntArray(5)
        var oneNumList = IntArray(5)
        if (n > 3) {
            zeroNumList = IntArray(n + 1)
            oneNumList = IntArray(n + 1)
        }

        zeroNumList[0] = 1
        oneNumList[0] = 0
        zeroNumList[1] = 0
        oneNumList[1] = 1
        zeroNumList[2] = 1
        oneNumList[2] = 1

        oneCount = 0
        zeroCount = 0
        if (n < 3) {
            bw.write("${zeroNumList[n]} ${oneNumList[n]}\n")
        } else {
            for (i in 3..n) {
                oneNumList[i] = oneNumList[i - 1] + oneNumList[i - 2]
                zeroNumList[i] = zeroNumList[i - 1] + zeroNumList[i - 2]
            }
            bw.write("${zeroNumList[n]} ${oneNumList[n]}\n")
        }
    }

    br.close()
    bw.close()

}

fun fibonacci(n: Int): Int {
    return when (n) {
        0 -> {
            zeroCount += 1
            0
        }
        1 -> {
            oneCount += 1
            1
        }
        else -> {
            fibonacci(n - 1) + fibonacci(n - 2)
        }
    }
}
