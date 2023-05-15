import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (r, c) = br.readLine().split(" ").map { it.toInt() }

    var map = Array(r) { IntArray(r) { 1 } }
    val xOffSet = listOf<Int>(-1, -1, 0)
    val yOffSet = listOf<Int>(0, -1, -1)
    repeat(c) {
        val tempList = mutableListOf<Int>()
        val temp = br.readLine().split(" ").map { it.toInt() }
        repeat(temp[0]) {
            tempList.add(0)
        }
        repeat(temp[1]) {
            tempList.add(1)
        }
        repeat(temp[2]) {
            tempList.add(2)
        }
        var index = 0
        val copyMap = map.map { it.copyOf() }
        for (i in r - 1 downTo 0) {
            copyMap[i][0] += tempList[index]
            index += 1
        }
        for (i in 1 until r) {
            copyMap[0][i] += tempList[index]
            index += 1
        }

        for (i in 1 until r) {
            for (j in 1 until r) {
                var plusNum = 0
                for (offset in 0..2) {
                    val checkX = j + xOffSet[offset]
                    val checkY = i + yOffSet[offset]
                    plusNum = maxOf(plusNum,copyMap[checkY][checkX]-map[checkY][checkX])
                }
                copyMap[i][j]+=plusNum
            }
        }
        map = copyMap.toTypedArray()
    }

    map.forEach {
        println(it.joinToString(" "))
    }
    bw.close()
}


