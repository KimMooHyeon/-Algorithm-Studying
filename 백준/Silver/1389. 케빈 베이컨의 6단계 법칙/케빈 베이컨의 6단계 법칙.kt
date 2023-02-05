import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val connect = Array(n) { IntArray(n) { Int.MAX_VALUE } }

    repeat(m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        connect[temp[0] - 1][temp[1] - 1] = 1
        connect[temp[1] - 1][temp[0] - 1] = 1
    }
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (connect[i][k] == Int.MAX_VALUE || connect[k][j] == Int.MAX_VALUE) {
                    continue
                }
                connect[i][j] = minOf(connect[i][j], connect[i][k] + connect[k][j])
            }
        }
    }
    var minNum = Int.MAX_VALUE
    var num = 0
    connect.forEachIndexed { i, v ->
        if (minNum>v.sum()){
            minNum=v.sum()
            num=i+1
        }
    }
    println(num)
    br.close()
    bw.close()
}

