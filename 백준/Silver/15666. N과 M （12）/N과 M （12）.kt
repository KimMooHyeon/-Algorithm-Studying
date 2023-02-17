import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var nList = br.readLine().split(" ").map { it.toInt() }

    val answer = mutableSetOf<List<Int>>()
    nList = nList.sorted().toSet().toList()
    fun sol(m: Int, selectedList: MutableList<Int>) {
        if (selectedList.size == m) {
            answer.add(selectedList.sorted())
            return
        }
        nList.forEachIndexed { i, v ->
            selectedList.add(v)
            sol(m, selectedList)
            selectedList.remove(v)
        }
    }
    sol(m, mutableListOf())

    answer.map { it.joinToString(" ") }.forEachIndexed { i, v ->
        if (i == answer.size - 1) {
            print(v)
        } else {
            println(v)
        }
    }
    br.close()
}

