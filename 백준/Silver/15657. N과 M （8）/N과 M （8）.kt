import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }.sorted()


    dfs(1, N, M, mutableListOf(), list.toMutableList())
    bw.close()
}

fun dfs(startIndex: Int, N: Int, M: Int, list: MutableList<Int>, problemList: MutableList<Int>) {
    if (list.size == M) {
        println(list.joinToString(" "))
        return
    }
    if (startIndex > N) {
        return
    }
    for (i in startIndex..N) {
        list.add(problemList[i - 1])
        dfs(i, N, M, list, problemList)
        list.remove(problemList[i - 1])
    }
}

