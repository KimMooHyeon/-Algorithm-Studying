import java.io.BufferedReader
import java.io.InputStreamReader

val xOffset = listOf(0, 0, 1, -1)
val yOffset = listOf(1, -1, 0, 0)

fun spreadDivide(map: Array<IntArray>, newMap: List<IntArray>, i: Int, j: Int, r: Int, c: Int) {
    val divideNum = map[i][j] / 5
    var spreadNum = 0
    for (index in 0..3) {
        val nextI = i + yOffset[index]
        val nextJ = j + xOffset[index]
        if (0 <= nextI && nextI < r && 0 <= nextJ && nextJ < c) {
            if (map[nextI][nextJ] != -1) {
                newMap[nextI][nextJ] += divideNum
                spreadNum += 1
            }
        }
    }
    newMap[i][j] -= (spreadNum * divideNum)
}

fun spread(map: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
    val newMap = map.map { it.copyOf() }
    for (i in 0 until r) {
        for (j in 0 until c) {
            // 5이상일때만 확산
            if (map[i][j] >= 5) {
                spreadDivide(map, newMap, i, j, r, c)
            }
        }
    }
    return cleanSpread( newMap, r, c)
}

fun cleanSpread(newMap: List<IntArray>, r: Int, c: Int) :Array<IntArray>{
    val upCleanY = cleanSpace[0]
    val downCleanY = cleanSpace[1]
    for (i in upCleanY-1 downTo 1){
        newMap[i][0]=newMap[i-1][0]
    }
    for (i in 0 until c-1){
        newMap[0][i]=newMap[0][i+1]
    }
    for (i in 0 until upCleanY){
        newMap[i][c-1]=newMap[i+1][c-1]
    }
    for (i in c-1 downTo 2){
        newMap[upCleanY][i]=newMap[upCleanY][i-1]
    }
    newMap[upCleanY][1]=0

    for (i in downCleanY+1 until  r-1){
        newMap[i][0]=newMap[i+1][0]
    }
    for (i in 0 until c-1){
        newMap[r-1][i]=newMap[r-1][i+1]
    }
    for (i in r-1 downTo  downCleanY+1){
        newMap[i][c-1]=newMap[i-1][c-1]
    }
    for (i in c-1 downTo 2){
        newMap[downCleanY][i]=newMap[downCleanY][i-1]
    }
    newMap[downCleanY][1]=0

    return newMap.map { it.copyOf() }.toTypedArray()

}

val cleanSpace = IntArray(2) { -1 }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c, t) = br.readLine().split(" ").map { it.toInt() }
    var map = Array(r) { IntArray(c) }
    repeat(r) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        temp.forEachIndexed { i, v ->
            if (v == -1) {
                if (cleanSpace[0] == -1) {
                    cleanSpace[0] = it
                } else {
                    cleanSpace[1] = it
                }
            }
            map[it][i] = v
        }
    }

    repeat(t) {
        map = spread(map, r, c)
    }
    var answer = 0
    map.forEach {
        it.forEach {
            if (it !=-1){
                answer+=it
            }
        }
    }
    println(answer)
    br.close()
}
