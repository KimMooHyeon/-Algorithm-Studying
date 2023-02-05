import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val connect = Array(n) { Array(n) { Int.MAX_VALUE } }
    repeat(m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        connect[temp[0] - 1][temp[1] - 1] = minOf(connect[temp[0] - 1][temp[1] - 1], temp[2])
    }
    repeat(n) {
        connect[it][it] = 0
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (connect[i][k] == Int.MAX_VALUE || connect[k][j] == Int.MAX_VALUE) continue
                if (connect[i][j] > connect[i][k] + connect[k][j]) {
                    connect[i][j] = connect[i][k] + connect[k][j]
                }
            }
        }
    }
    connect.forEach { array ->
        array.forEach { distance ->
            print("${if (distance == Int.MAX_VALUE) 0 else distance} ")
        }
        println()
    }

    br.close()
    bw.close()
}

