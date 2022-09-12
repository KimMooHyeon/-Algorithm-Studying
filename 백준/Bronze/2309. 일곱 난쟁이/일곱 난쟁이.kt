import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.TreeSet

val smallManList = mutableListOf<Int>()
var checkResult = false
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    for (i in 1..9) {
        smallManList.add(br.readLine().toInt())
    }
    dfs(0, 0, 0, mutableListOf())

}

fun dfs(sum: Int, count: Int, index: Int, checkList: List<Int>) {
    if (count > 7 || sum > 100 || checkResult) {
        return
    }
    if (sum == 100 && count == 7) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        checkList.sorted().map { println("$it") }
        checkResult=true
    } else {
        if (index >= 9) {
            return
        }
        dfs(sum, count, index + 1, checkList.map { it })
        dfs(sum + smallManList[index], count + 1, index + 1, checkList.map { it } + smallManList[index])
    }
}