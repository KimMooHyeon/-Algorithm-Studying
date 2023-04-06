import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

data class CostCity(val cost: Int, val customer: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (c, n) = br.readLine().split(" ").map { it.toInt() }


    val costList = mutableListOf<CostCity>()
    repeat(n) {
        // 비용, 비용으로 얻을 수 있는 고객수
        val city = br.readLine().split(" ").map { it.toInt() }
        costList.add(CostCity(city[0], city[1]))
    }

    val dp = IntArray(c+100) { Int.MAX_VALUE }
    dp[0]=0

    costList.forEach {
        for (i in it.customer until  c+100){
            if (!(it.cost == Int.MAX_VALUE || dp[i-it.customer] == Int.MAX_VALUE)){
                dp[i] = minOf(dp[i-it.customer]+it.cost,dp[i])
            }
        }
    }

    var smallNum = Int.MAX_VALUE
    for (i in c until  c+100){
        smallNum= minOf(dp[i],smallNum)
    }
    println(smallNum)


    br.close()
    bw.close()
}