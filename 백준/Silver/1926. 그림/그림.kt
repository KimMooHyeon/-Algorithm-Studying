import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

var maxResult = 0
var num = 0
var sizeNum=0
var xOffset = listOf<Int>(1, -1, 0, 0)
var yOffset = listOf<Int>(0, 0, 1, -1)
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val mapList = mutableListOf<MutableList<Int>>()
    for (i in 1..n) {
        val mList = br.readLine().split(" ").map { it.toInt() }
        mapList.add(mList.toMutableList())
    }
    mapList.forEachIndexed { y, ints ->

        ints.forEachIndexed { x, i ->
            if (mapList[y][x] == 1) {
                num += 1
                sizeNum=0
                dfs(x, y, 1, mapList, n, m)
                maxResult = max(sizeNum, maxResult)
                sizeNum=0
            }
        }
    }
    println(num)
    println(maxResult)
    bw.close()
}

fun dfs(x: Int, y: Int, size: Int, mapList: MutableList<MutableList<Int>>, n: Int, m: Int) {
    if (mapList[y][x] == 1) {
        sizeNum+=1
        mapList[y][x] = 0
        for (i in 0 until 4) {
            if ((x + xOffset[i] in 0 until m) && (y + yOffset[i] in 0 until n)) {
                if (mapList[y + yOffset[i]][x + xOffset[i]] == 1) {
                    dfs(x + xOffset[i], y + yOffset[i], size + 1, mapList, n, m)
                }
            }
        }
    }
}