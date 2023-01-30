import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

data class Graph(val number: Int, val distance: Int)

val hs = HashMap<Pair<Int, Int>, Int>()
var num = 0
lateinit var map: Array<MutableList<Graph>>
lateinit var booleanMap: BooleanArray
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    //세로 가로
    val v = br.readLine().toInt()
    map = Array(v + 1) { mutableListOf() }
    booleanMap = BooleanArray(v + 1) { true }
    repeat(v) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        for (i in 1 until temp.size step (2)) {
            if (temp[i] == -1) {
                break
            } else {
                map[temp[0]].add(Graph(temp[i], temp[i + 1]))
            }
        }
    }

    dfs(1, 0)
    dfs(deepNode, 0)
    
    println(num)
    br.close()
    bw.close()
}

var deepNode = 0
fun dfs(index: Int, sum: Int) {
    if (sum > num) {
        num = sum
        deepNode=index
    }
    if (booleanMap[index]) {
        booleanMap[index] = false
        map[index].forEach {
            if (booleanMap[it.number]) {
                dfs(it.number, sum + it.distance)
            }
        }
        booleanMap[index] = true
    }
}