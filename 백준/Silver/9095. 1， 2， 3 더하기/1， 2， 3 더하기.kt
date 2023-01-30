import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var num = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    //세로 가로
    val case = br.readLine().toInt()
    repeat(case) {
        val n = br.readLine().toInt()
        solve(0, 0, n)
        bw.write("${num}\n")
        num = 0
    }

    br.close()
    bw.close()
}

fun solve(numCount: Int, nowSum: Int, destination: Int) {
    if (nowSum == destination) {
        num += 1
    }
    if (numCount > destination || nowSum > destination) {
        return
    }
    for (i in 1..3) {
        solve(numCount + 1, nowSum + i, destination)
    }

}