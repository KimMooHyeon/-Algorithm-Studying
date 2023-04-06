import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun dfs(index: Int, dp: Array<IntArray>, tree: Array<MutableList<Int>>, visit: BooleanArray) {
// 0은 아닐때 , 1은 어답터일때
    visit[index] = false
    dp[index][0] = 0
    dp[index][1] = 1
    for (i in 0 until tree[index].size) {
        if (visit[tree[index][i]]) {
            visit[tree[index][i]] = false
            dfs(tree[index][i], dp, tree, visit)
            dp[index][0] += dp[tree[index][i]][1]
            dp[index][1] += minOf(dp[tree[index][i]][0], dp[tree[index][i]][1])
        }
    }
}

// 얼리 아답터가 아닌 사람들은 자신의 모든 친구들이 얼리 아답터일 때만 이 아이디어를 받아들인다.
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()
    val dp = Array(N + 1) { IntArray(2) }
    val tree = Array(N + 1) { mutableListOf<Int>() }
    val visit = BooleanArray(N + 1) { true }
    repeat(N - 1) {
        val edge = br.readLine().split(" ").map { it.toInt() }
        tree[edge[0]].add(edge[1])
        tree[edge[1]].add(edge[0])
    }
    dfs(1, dp, tree, visit)
    println(minOf(dp[1][0], dp[1][1]))
    br.close()
    bw.close()
}