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
        connect[temp[0] - 1][temp[1] - 1] = temp[2]
    }

    val temp = mutableListOf<Int>()
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (connect[i][k] == Int.MAX_VALUE || connect[k][j] == Int.MAX_VALUE) {
                    continue
                }
                if (i == j){
                    continue
                }
                if (connect[i][j] > connect[i][k] + connect[k][j]) {
                    connect[i][j] = connect[i][k] + connect[k][j]
                }
            }
        }
    }

    connect.forEachIndexed { i, v ->
    
        v.forEachIndexed { index, value ->
            if (connect[i][index] != Int.MAX_VALUE && connect[index][i] != Int.MAX_VALUE) {
                if (i == index) {
                    temp.add(connect[i][index])
                } else {
                    temp.add(connect[i][index] + connect[index][i])
                }
            }
        }
    }
    temp.sort()
    if (temp.isEmpty()) {
        println(-1)
    } else {
        println(temp[0])
    }
    br.close()
    bw.close()
}

