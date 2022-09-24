import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var resNum = 0
var a = arrayOf(0, 0, 1, -1)
var b = arrayOf(1, -1, 0, 0)
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val T = br.readLine().toInt()

    for (i in 1..T) {
        val (M, N, K) = br.readLine().split(" ").map { it.toInt() }
        val mapList = Array(N) { IntArray(M) }

        for (k in 1..K) {
            val (X, Y) = br.readLine().split(" ").map { it.toInt() }
            mapList[Y][X] = 1
        }
        mapList.forEachIndexed { index, ints ->
            ints.forEachIndexed { valueIndex, i ->
                if (mapList[index][valueIndex] == 1) {
                    resNum += 1
                 //   println("여기 $index $valueIndex")
                    bfs(mapList,index,valueIndex)
                }
            }
        }
        println(resNum)
        resNum = 0
    }
    br.close()
    bw.close()
}

fun bfs(mapList: Array<IntArray>, Y: Int, X: Int) {
    mapList[Y][X] = 0
    for (i in 0 until 4) {
       // println("bfs 이거 확인 ${Y + a[i]} ${X + b[i]}")
        if ((Y + a[i] >= 0 && Y + a[i] < mapList.size) && (X + b[i] >= 0 && X + b[i] < mapList[0].size)) {
       //     println("bfs 확인 ${Y + a[i]} ${X + b[i]}")
            if (mapList[Y + a[i]][X + b[i]] == 1) {
                bfs(mapList, Y + a[i], X + b[i])
            }
        }
    }
}