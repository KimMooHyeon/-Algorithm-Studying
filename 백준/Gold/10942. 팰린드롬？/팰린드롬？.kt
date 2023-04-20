import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun check(s: Int, e: Int, nList: List<Int>, dp: Array<IntArray>, n: Int): Int {

    if (s == e) {
        return 1
    }
    if (dp[s][e] != -1) {
        return dp[s][e]
    }

    var left = s
    var right = e
    while (left < right) {

        if (nList[left] != nList[right]) {

            for (i in right..n){
                if (dp[left][i]!=-1){
                    break
                }
                dp[left][i] = 0
                left-=1
                if (left<1){
                    break
                }
            }
                return 0
        } else {
            left += 1
            right -= 1
        }
    }
    left = s
    right = e
    while (left < right) {
        if (dp[left][right] != -1) {
            break
        }
        dp[left][right] = 1
        left += 1
        right -= 1
    }
    return 1
}

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val dp = Array(n + 1) { IntArray(n + 1) { -1 } }
    repeat(n) {
        dp[it + 1][it + 1] = 1
    }
    val nList = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()
    repeat(m) {
        val (_s, _e) = br.readLine().split(" ").map { it.toInt() }
        val s = _s - 1
        val e = _e - 1

        bw.write("${check(s, e, nList, dp, n)}\n")

    }

    br.close()
    bw.close()
}
