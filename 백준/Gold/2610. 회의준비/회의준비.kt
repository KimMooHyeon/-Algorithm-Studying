import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val connect = Array(n) { IntArray(n) { Int.MAX_VALUE } }

    repeat(m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        connect[temp[0] - 1][temp[1] - 1] = 1
        connect[temp[1] - 1][temp[0] - 1] = 1
    }
    repeat(n) {
        connect[it][it] = 0
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (connect[i][k] == Int.MAX_VALUE || connect[k][j] == Int.MAX_VALUE) {
                    continue
                }
                if (connect[i][j]>connect[i][k] + connect[k][j]){
                    connect[i][j]=connect[i][k] + connect[k][j]
                }
            }
        }
    }
    val checkArray = BooleanArray(n) { true }
    var groupNum = 0
    var groupNumList = mutableListOf<Int>()
    connect.forEachIndexed { i, v ->
      //  println(v.contentToString())
        if (checkArray[i]) {
            groupNum += 1
            val temp = mutableListOf<Int>()
            v.forEachIndexed { index, value ->
                if (value != Int.MAX_VALUE) {
                    temp.add(index)
                    checkArray[index] = false
                }
            }
            var maxNum = Int.MAX_VALUE
            var maxIndex = 0
      /*      temp.forEach {
                print("$it ")
            }
            println()*/
            temp.forEachIndexed { index, i ->
                val numSum =connect[i].filter { it != Int.MAX_VALUE }.max()
                if (maxNum > numSum) {
                    maxIndex=i
                    maxNum= numSum
                }
            }
            groupNumList.add(maxIndex+1)
        }
    }

    println(groupNum)
    groupNumList.sort()
    groupNumList.forEach {
        println(it)
    }
    br.close()
    bw.close()
}

