import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import kotlin.math.max

val map = mutableListOf<List<String>>()
val setList = mutableSetOf<String>()
val dx = listOf(0, 0, 1, -1)
val dy = listOf(1, -1, 0, 0)
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    for (i in 0..4) {
        map.add(br.readLine().split(" "))
    }
    for (i in 0..4) {
        for (j in 0..4) {
            dfs(i, j, map[i][j])
        }
    }
    println(setList.size)
}

fun dfs(x: Int, y: Int, s: String) {
    if (s.length == 6) {
        if (s !in setList) {
            setList.add(s)
        }
        return
    }
    for (i in 0..3) {
        val a = x + dx[i]
        val b = y + dy[i]
        if (a in 0 until 5 && b in 0 until 5) {
            dfs(a, b, s + map[a][b])
        }
    }
}
