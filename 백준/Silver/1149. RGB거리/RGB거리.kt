import java.io.BufferedReader
import java.io.BufferedWriter
import  java.io.InputStreamReader
import java.io.OutputStreamWriter

data class RgbCost(val index: Int, val red: Int, val green: Int, val blue: Int)

lateinit var homeList: MutableList<RgbCost>

lateinit var redArray: IntArray
lateinit var greenArray: IntArray
lateinit var blueArray: IntArray
lateinit var mainArray: IntArray
var homeSize = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val N = br.readLine().toInt()
    homeList = mutableListOf<RgbCost>()
    redArray = IntArray(N)
    greenArray = IntArray(N)
    blueArray = IntArray(N)
    mainArray = IntArray(N)

    repeat(N) { index ->
        val cost = br.readLine().split(" ").map { it.toInt() }
        homeList.add(RgbCost(index, cost[0], cost[1], cost[2]))
    }
    redArray[0] = homeList[0].red
    greenArray[0] = homeList[0].green
    blueArray[0] = homeList[0].blue

    for (i in 1 until N) {
        redArray[i] += minOf(blueArray[i - 1], greenArray[i - 1]) + homeList[i].red
        blueArray[i] += minOf(greenArray[i - 1], redArray[i - 1]) + homeList[i].blue
        greenArray[i] += minOf(blueArray[i - 1], redArray[i - 1]) + homeList[i].green
    }

    homeSize = homeList.size

    bw.write("${minOf(redArray[N-1],blueArray[N-1],greenArray[N-1])}\n")

    br.close()
    bw.close()
}