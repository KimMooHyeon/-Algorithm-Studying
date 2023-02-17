import java.io.BufferedReader
import java.io.InputStreamReader

data class Number(val index: Int, val number: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var nList = br.readLine().split(" ").map { it.toInt() }

    val answer = mutableSetOf<List<Int>>()
    nList = nList.sorted()
    fun sol(m: Int, selectedList: MutableList<Number>) {
        if (selectedList.size == m) {
            answer.add(selectedList.map { it.number })
            return
        }
        nList.forEachIndexed { i, v ->
            val num = Number(i, v)
            if (num !in selectedList) {
                selectedList.add(num)
                sol(m, selectedList)
                selectedList.remove(num)
            }
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

