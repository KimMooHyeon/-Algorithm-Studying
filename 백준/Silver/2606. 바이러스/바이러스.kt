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
        connect[temp[0] - 1][temp[1] - 1] = minOf(connect[temp[0] - 1][temp[1] - 1], 1)
        connect[temp[1] - 1][temp[0] - 1] = minOf(connect[temp[1] - 1][temp[0] - 1], 1)
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (connect[i][k] == Int.MAX_VALUE || connect[k][j] == Int.MAX_VALUE) {
                    continue
                }
                if (connect[i][j] > connect[i][k] + connect[k][j]) {
                    connect[i][j] = connect[i][k] + connect[k][j]
                }
            }
        }
    }
    var num = 0
    for (i in 1 until n){
        if (connect[0][i] != Int.MAX_VALUE || connect[i][0] != Int.MAX_VALUE) {
            num += 1
        }
    }
  
    println(num)

    br.close()
    bw.close()
}

