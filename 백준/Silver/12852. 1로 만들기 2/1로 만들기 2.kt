import java.io.BufferedReader
import java.io.InputStreamReader


var answer = ""
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dp = IntArray(n + 1) { it }
    for (i in 2..n) {
        if (i % 2 == 0) {
            dp[i] = minOf(dp[i], dp[i / 2] + 1)
        }
        if (i % 3 == 0) {
            dp[i] = minOf(dp[i], dp[i / 3] + 1)
        }
        dp[i] = minOf(dp[i], dp[i - 1] + 1)
    }
  
    var start = n
    val answerList = mutableListOf<Int>()
    answerList.add(start)
    while (start != 1) {
        if (start % 2 == 0 && start % 3 == 0) {
            if (dp[start / 2] > dp[start / 3]) {
                if (dp[start / 3] > dp[start - 1]) {
                    start = start - 1
                    answerList.add(start)
                } else {
                    start = start / 3
                    answerList.add(start)
                }
            } else {
                if (dp[start / 2] > dp[start - 1]) {
                    start = start - 1
                    answerList.add(start)
                } else {
                    start = start / 2
                    answerList.add(start)
                }
            }
        }else if (start % 2 == 0 && start % 3 != 0){
            if (dp[start / 2] > dp[start - 1]) {
                start = start - 1
                answerList.add(start)
            } else {
                start = start / 2
                answerList.add(start)
            }
        }else if (start % 2 != 0 && start % 3 == 0){
            if (dp[start / 3] > dp[start - 1]) {
                start = start - 1
                answerList.add(start)
            } else {
                start = start / 3
                answerList.add(start)
            }
        }else{
            start = start - 1
            answerList.add(start)
        }
    }
    println(dp[n]-1)
    println(answerList.joinToString(" "))
}

// 10 5 4 2 1
// 10 9 3 1
