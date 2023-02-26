import java.io.BufferedReader
import java.io.InputStreamReader

data class RgbList(var red: Int, var green: Int, var blue: Int)

val maxInt = 10000
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val rList = IntArray(n + 1)
    val gList = IntArray(n + 1)
    val bList = IntArray(n + 1)
    val rgbList = Array<RgbList>(n + 1) { RgbList(0, 0, 0) }
    val startRList = IntArray(n + 1)
    val startGList = IntArray(n + 1)
    val startBList = IntArray(n + 1)


    val answerList = mutableListOf<Int>()
    repeat(n) {
        val (r, g, b) = br.readLine().split(" ").map { it.toInt() }
        rgbList[it + 1] = RgbList(r, g, b)
    }
    startRList[1] = rgbList[1].red
    startBList[1] = rgbList[1].blue
    startGList[1] = rgbList[1].green

    for (index in 0..2) {
        when (index) {
            0 -> {
                rList[1] = rgbList[1].red
                bList[1] = maxInt
                gList[1] = maxInt

                //red를 먼져 칠함
                for (i in 2 until n) {
                    rList[i] = minOf(gList[i - 1], bList[i - 1]) + rgbList[i].red
                    gList[i] = minOf(rList[i - 1], bList[i - 1]) + rgbList[i].green
                    bList[i] = minOf(gList[i - 1], rList[i - 1]) + rgbList[i].blue
                }
                gList[n] = minOf(rList[n - 1], bList[n - 1]) + rgbList[n].green
                bList[n] = minOf(gList[n - 1], rList[n - 1]) + rgbList[n].blue
                answerList.add(minOf(gList[n], bList[n]))
            }
            1 -> {
                rList[1] = maxInt
                bList[1] = maxInt
                gList[1] = startGList[1]

                //green를 먼져 칠함
                for (i in 2 until n) {
                    rList[i] = minOf(gList[i - 1], bList[i - 1]) + rgbList[i].red
                    gList[i] = minOf(rList[i - 1], bList[i - 1]) + rgbList[i].green
                    bList[i] = minOf(gList[i - 1], rList[i - 1]) + rgbList[i].blue
                }
                rList[n] = minOf(gList[n - 1], bList[n - 1]) + rgbList[n].red
                bList[n] = minOf(gList[n - 1], rList[n - 1]) + rgbList[n].blue
                answerList.add(minOf(rList[n], bList[n]))
            }
            2 -> {
                rList[1] = maxInt
                bList[1] = startBList[1]
                gList[1] = maxInt

                //blue를 먼져 칠함
                for (i in 2 until n) {
                    rList[i] = minOf(gList[i - 1], bList[i - 1]) + rgbList[i].red
                    gList[i] = minOf(rList[i - 1], bList[i - 1]) + rgbList[i].green
                    bList[i] = minOf(gList[i - 1], rList[i - 1]) + rgbList[i].blue
                }
                rList[n] = minOf(gList[n - 1], bList[n - 1]) + rgbList[n].red
                gList[n] = minOf(rList[n - 1], bList[n - 1]) + rgbList[n].green
                answerList.add(minOf(gList[n], rList[n]))
            }
            else -> {
            }
        }
    }
    println(answerList.minOrNull()!!)
}
