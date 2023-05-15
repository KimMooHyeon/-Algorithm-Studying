import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val num = br.readLine().toInt()
    val friendList = Array(num + 1) { mutableListOf<Int>() }

    val scoreMap = Array(num + 1) { IntArray(num + 1) { Int.MAX_VALUE } }
    while (true) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        if (temp[0] == -1 && temp[1] == -1) {
            break
        }
        if (scoreMap[temp[0]][temp[1]] > 1) {
            scoreMap[temp[0]][temp[1]] = 1
        }
        if (scoreMap[temp[1]][temp[0]] > 1) {
            scoreMap[temp[1]][temp[0]] = 1
        }
    }
    repeat(num+1){
        scoreMap[it][it]=0
    }

    for (k in 1..num) {
        for (i in 1..num) {
            for (j in 1..num) {
                if (scoreMap[i][k] != Int.MAX_VALUE && scoreMap[k][j] != Int.MAX_VALUE) {
                    if (scoreMap[i][j] > scoreMap[i][k] + scoreMap[k][j]) {
                        scoreMap[i][j] = scoreMap[i][k] + scoreMap[k][j]
                    }
                }
                if (scoreMap[j][k] != Int.MAX_VALUE && scoreMap[k][i] != Int.MAX_VALUE) {
                    if (scoreMap[j][i] > scoreMap[j][k] + scoreMap[k][i]) {
                        scoreMap[j][i] = scoreMap[j][k] + scoreMap[k][i]
                    }
                }
            }
        }
    }
    val hash = HashMap<Int, MutableList<Int>>()
    var checkMax = Int.MAX_VALUE
    for (i in 1..num) {
        var max = -1
        for (index in 1..num) {
            max = maxOf(scoreMap[i][index], max)
        }
        if (max in hash) {
            hash[max]!!.add(i)
        } else {
            hash[max] = mutableListOf(i)
        }
        checkMax = minOf(max,checkMax)
    }
    println("${checkMax} ${hash[checkMax]!!.size}")
    println(hash[checkMax]!!.joinToString(" "))
    //bw.write(ans.toString())
    bw.close()
}


