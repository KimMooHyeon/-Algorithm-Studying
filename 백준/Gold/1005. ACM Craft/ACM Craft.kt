import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun getMinTime(findNum: Int, graph: Array<MutableList<Int>>, dpTime: IntArray, dTimeArray: IntArray): Int {
    if (dpTime[findNum] != -1) {
        return dpTime[findNum]
    }
    return if (graph[findNum].isEmpty()) {
        dpTime[findNum] = dTimeArray[findNum]
        dTimeArray[findNum]
    } else {
        val maxNum = graph[findNum].map { getMinTime(it, graph, dpTime, dTimeArray) }.max() + dTimeArray[findNum]
        dpTime[findNum] = maxNum
        maxNum
    }

}

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val tc = br.readLine().toInt()
    repeat(tc) {
        // 건물의 개수, 건설순서 규칙의 총개수
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(n + 1) { mutableListOf<Int>() }
        val dpTime = IntArray(n + 1){-1}
        // 각 건물당 건물에 걸리는 시간
        val dArray = br.readLine().split(" ").map { it.toInt() }
        val dTimeArray = IntArray(n + 1)
        repeat(n) {
            dTimeArray[it + 1] = dArray[it]
        }
        repeat(k) { index ->
            // 건물 순서 x를 지은 다음에 건물 Y를 짓는것이 가능
            val temp = br.readLine().split(" ").map { it.toInt() }
            graph[temp[1]].add(temp[0])
        }
        val findNum = br.readLine().toInt()
        bw.write("${getMinTime(findNum, graph, dpTime, dTimeArray)}\n")
    }
    br.close()
    bw.close()
}
