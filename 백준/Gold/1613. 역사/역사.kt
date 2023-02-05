import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val connect = Array(n) { IntArray(n) { -1 } }
    val tempList = mutableListOf<Int>()
    repeat(m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        connect[temp[0] - 1][temp[1] - 1] =  1
    }
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (connect[i][k] == -1 || connect[k][j] == -1) {
                    continue
                }
                connect[i][j] = connect[i][k] + connect[k][j]
            }
        }
    }
    val s = br.readLine().toInt()
    repeat(s){
        val temp = br.readLine().split(" ").map { it.toInt() }
        if(connect[temp[0] - 1][temp[1] - 1] >=1){
            tempList.add(-1)
        }else if(connect[temp[1] - 1][temp[0] - 1] >=1){
            tempList.add(1)
        }else{
            tempList.add(0)
        }
    }

    tempList.forEach {
        println(it)
    }
    br.close()
    bw.close()
}

