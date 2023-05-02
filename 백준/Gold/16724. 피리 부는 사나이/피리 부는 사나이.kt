import java.io.BufferedReader
import java.io.InputStreamReader

fun dfs(i: Int, j: Int, map: Array<Array<String>>, safeCheck: Array<BooleanArray>, isVisited: Array<BooleanArray>) {
    isVisited[i][j] = false
    when (map[i][j]) {
        "L" -> {
            val point = Pair(i, j - 1)
            if (point !in hash) {
                hash[point] = true
                if (map[i][j - 1] == "safe") {
                    safeCheck[i][j] = true
                    map[i][j] = "safe"
                    return
                }
                map[i][j] = "safe"
                isVisited[i][j - 1] = false
                safeCheck[i][j] = true
                dfs(i, j - 1, map, safeCheck, isVisited)
            } else {
                map[i][j] = "safe"
                safeCheck[i][j] = true
                answer += 1
                return
            }
        }
        "R" -> {
            val point = Pair(i, j + 1)
            if (point !in hash) {
                hash[point] = true
                if (map[i][j + 1] == "safe") {
                    safeCheck[i][j] = true
                    map[i][j] = "safe"
                    return
                }
                map[i][j] = "safe"
                isVisited[i][j + 1] = false
                safeCheck[i][j] = true
                dfs(i, j + 1, map, safeCheck, isVisited)
            } else {
                map[i][j] = "safe"
                safeCheck[i][j] = true
                answer += 1
                return
            }
        }
        "D" -> {
            val point = Pair(i + 1, j)
            if (point !in hash) {
                hash[point] = true
                if (map[i + 1][j] == "safe") {
                    safeCheck[i][j] = true
                    map[i][j] = "safe"
                    return
                }
                map[i][j] = "safe"
                isVisited[i + 1][j] = false
                safeCheck[i][j] = true
                dfs(i + 1, j, map, safeCheck, isVisited)
            } else {
                map[i][j] = "safe"
                safeCheck[i][j] = true
                answer += 1
                return
            }
        }
        "U" -> {
            val point = Pair(i - 1, j)
            if (point !in hash) {
                hash[point] = true
                if (map[i - 1][j] == "safe") {
                    safeCheck[i][j] = true
                    return
                }
                map[i][j] = "safe"
                isVisited[i - 1][j] = false
                safeCheck[i][j] = true
                dfs(i - 1, j, map, safeCheck, isVisited)
            } else {
                map[i][j] = "safe"
                safeCheck[i][j] = true
                answer += 1
                return
            }
        }
    }
}

var answer = 0
var hash = HashMap<Pair<Int, Int>, Boolean>()
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 학생 N명
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { Array<String>(m) { "" } }
    val safeCheck = Array(n) { BooleanArray(m) { false } }
    val isVisited = Array(n) { BooleanArray(m) { true } }
    val temp = Array(n) { BooleanArray(m) { true } }
    repeat(n) { row ->
        val temp = br.readLine().split("").map { it.toString() }
        repeat(m) {
            map[row][it] = temp[it + 1]
        }
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (safeCheck[i][j].not()) {
                // 제일 마지막에 도착하는거 세이프존 만들기
                safeCheck[i][j] = true
                hash.clear()
                hash[Pair(i,j)]=true
                dfs(i, j, map, safeCheck, isVisited)
            }
        }
    }
    println(answer)
}
