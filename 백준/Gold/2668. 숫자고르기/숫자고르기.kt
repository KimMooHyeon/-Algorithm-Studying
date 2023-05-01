import java.io.BufferedReader
import java.io.InputStreamReader

fun dfs(start: Int, firstKey: Int, first: IntArray, second: IntArray, check: BooleanArray): Boolean {

    if (check[firstKey]) {
        check[firstKey] = false
    } else {
        return start == firstKey
    }
    return dfs(start, second[firstKey], first, second, check)
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var check = BooleanArray(n + 1) { true }
    val first = IntArray(n + 1) { it }
    val second = IntArray(n + 1)
    val answerList = mutableSetOf<Int>()
    repeat(n) {
        val num = br.readLine().toInt()
        second[it + 1] = num
    }
/*    println(first.contentToString())
    println(second.contentToString())*/
    for (i in 1..n) {
        check = BooleanArray(n + 1) { true }
        if (dfs(i, i, first, second, check)) {
            answerList.add(second[i])
        }
    }
    println(answerList.size)
    answerList.sorted().forEach {
        println(it)
    }
}

