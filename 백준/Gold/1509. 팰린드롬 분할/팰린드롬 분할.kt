import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun check(s: Int, e: Int, nList: List<String>, dp: Array<IntArray>, n: Int) {

    if (s == e) {
        dp[s][e] = 1
        return
    }
    if (dp[s][e] != -1) {
        return
    }

    var left = s
    var right = e
    while (left < right) {

        if (nList[left] != nList[right]) {
            for (i in right..n) {
                if (dp[left][i] != -1) {
                    break
                }
                dp[left][i] = 0
                left -= 1
                if (left < 1) {
                    break
                }
            }
            return
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
    return
}

var answerNum = Int.MAX_VALUE
fun getMinNum(start: Int, dp: Array<IntArray>, checkDp: IntArray, n: Int, answer: Int) {
    if (answer >= answerNum) {
        return
    }
    if (start > 1) {
        if (checkDp[start - 1] < answer) {
            return
        } else {
            checkDp[start - 1] = answer
        }
    }

    if (start >= n + 1) {
        answerNum = minOf(answerNum, answer)
        return
    }
    for (i in n downTo start) {
        if (dp[start][i] == 1) {
            if (answer < checkDp[i]) {
                getMinNum(i + 1, dp, checkDp, n, answer + 1)
                checkDp[i]=answer
            }
        }
    }
}

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val inputString = br.readLine()
    val n = inputString.length
    val dp = Array(n + 1) { IntArray(n + 1) { -1 } }
    val checkDp = IntArray(n + 1) { it }
    val nList = inputString.split("")
    for (i in 0..n) {
        for (j in i..n) {
            if (dp[i][j] == -1) {
                check(i, j, nList, dp, n)
            }
        }
    }
    getMinNum(1, dp, checkDp, n, 0)
    println(answerNum)

    br.close()
    bw.close()
}
