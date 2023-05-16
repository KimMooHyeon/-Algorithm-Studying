import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

data class CCTV(val information: Int, val distinct: String = "Start", val y: Int, val x: Int)

val change = listOf<String>("L", "R", "U", "D")
var answer = Int.MAX_VALUE
val cctvList = mutableListOf<CCTV>()
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    // 세로 n 가로 m
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }

    var minusNum = 0
    repeat(n) { y ->
        val temp = br.readLine().split(" ").map { it.toInt() }
        temp.forEachIndexed { i, x ->
            if (x != 0 && x != 6) {
                cctvList.add(CCTV(x, "Start", y, i))
                minusNum += 1
            }
            if (x == 6) {
                minusNum += 1
            }
            map[y][i] = x
        }
    }
    answer = n * m - minusNum
    dfs(cctvList.size, map, 0, 0, n * m - minusNum, n, m)
    println(answer)
    bw.close()
}

fun activeLeft(map: Array<IntArray>, n: Int, m: Int, nowY: Int, nowX: Int): Int {
    var cleanNum = 0
    val curY = nowY
    var curX = nowX
    while (true) {
        curX -= 1
        if (curX < 0) {
            //맵초과
            break
        }
        if (map[curY][curX] == 6) {
            break
        }
        if (map[curY][curX] == 0) {
            map[curY][curX] = -1
            cleanNum += 1
        }
    }
    return cleanNum
}

fun activeRight(map: Array<IntArray>, n: Int, m: Int, nowY: Int, nowX: Int): Int {
    var cleanNum = 0
    val curY = nowY
    var curX = nowX
    while (true) {
        curX += 1
        if (curX >= m) {
            //맵초과
            break
        }
        if (map[curY][curX] == 6) {
            break
        }
        if (map[curY][curX] == 0) {
            map[curY][curX] = -1
            cleanNum += 1
        }
    }
    return cleanNum
}

fun activeUp(map: Array<IntArray>, n: Int, m: Int, nowY: Int, nowX: Int): Int {
    var cleanNum = 0
    var curY = nowY
    val curX = nowX
    while (true) {
        curY += 1
        if (curY >= n) {
            //맵초과
            break
        }
        if (map[curY][curX] == 6) {
            break
        }
        if (map[curY][curX] == 0) {
            map[curY][curX] = -1
            cleanNum += 1
        }
    }
    return cleanNum
}

fun activeDown(map: Array<IntArray>, n: Int, m: Int, nowY: Int, nowX: Int): Int {
    var cleanNum = 0
    var curY = nowY
    val curX = nowX
    while (true) {
        curY -= 1
        if (curY < 0) {
            //맵초과
            break
        }
        if (map[curY][curX] == 6) {
            break
        }
        if (map[curY][curX] == 0) {
            map[curY][curX] = -1
            cleanNum += 1
        }
    }
    return cleanNum
}

fun dfs(cctvNum: Int, _map: Array<IntArray>, cctvIndex: Int, _cleanNum: Int, allMap: Int, n: Int, m: Int) {

    if (cctvNum == cctvIndex) {
        answer = minOf(answer, allMap - _cleanNum)
        return
    }
    when (cctvList[cctvIndex].information) {
        1 -> {
            for (i in 0..3) {
                when (change[i]) {
                    "L" -> {
                        var cleanNum = _cleanNum
                        val map = _map.map { it.copyOf() }.toTypedArray()
                        cleanNum += activeLeft(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
                    }
                    "R" -> {
                        var cleanNum = _cleanNum
                        val map = _map.map { it.copyOf() }.toTypedArray()
                        cleanNum += activeRight(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
                    }
                    "U" -> {
                        var cleanNum = _cleanNum
                        val map = _map.map { it.copyOf() }.toTypedArray()
                        cleanNum += activeUp(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
                    }
                    "D" -> {
                        var cleanNum = _cleanNum
                        val map = _map.map { it.copyOf() }.toTypedArray()
                        cleanNum += activeDown(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
                    }
                }
            }
        }
        2 -> {
            for (i in 1..2) {
                when (change[i]) {
                    "R" -> {
                        var cleanNum = _cleanNum
                        val map = _map.map { it.copyOf() }.toTypedArray()
                        cleanNum += activeLeft(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        cleanNum += activeRight(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
                    }
                    "U" -> {
                        var cleanNum = _cleanNum
                        val map = _map.map { it.copyOf() }.toTypedArray()
                        cleanNum += activeDown(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        cleanNum += activeUp(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
                    }
                }
            }
        }
        3 -> {
            for (i in 0..3) {
                when (change[i]) {
                    "L" -> {
                        var cleanNum = _cleanNum
                        val map = _map.map { it.copyOf() }.toTypedArray()
                        cleanNum += activeUp(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        cleanNum += activeLeft(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
                    }
                    "D" -> {
                        var cleanNum = _cleanNum
                        val map = _map.map { it.copyOf() }.toTypedArray()
                        cleanNum += activeDown(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        cleanNum += activeRight(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
                    }
                    "R" -> {
                        var cleanNum = _cleanNum
                        val map = _map.map { it.copyOf() }.toTypedArray()
                        cleanNum += activeUp(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        cleanNum += activeRight(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
                    }
                    "U" -> {
                        var cleanNum = _cleanNum
                        val map = _map.map { it.copyOf() }.toTypedArray()
                        cleanNum += activeDown(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        cleanNum += activeLeft(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
                    }
                }
            }
        }
        4 -> {
            for (i in 0..3) {
                when (change[i]) {
                    "L" -> {
                        var cleanNum = _cleanNum
                        val map = _map.map { it.copyOf() }.toTypedArray()
                        cleanNum += activeDown(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        cleanNum += activeUp(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        cleanNum += activeLeft(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
                    }
                    "R" -> {
                        var cleanNum = _cleanNum
                        val map = _map.map { it.copyOf() }.toTypedArray()
                        cleanNum += activeUp(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        cleanNum += activeDown(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        cleanNum += activeRight(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
                    }
                    "U" -> {
                        var cleanNum = _cleanNum
                        val map = _map.map { it.copyOf() }.toTypedArray()
                        cleanNum += activeLeft(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        cleanNum += activeRight(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        cleanNum += activeUp(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
                    }
                    "D" -> {
                        var cleanNum = _cleanNum
                        val map = _map.map { it.copyOf() }.toTypedArray()
                        cleanNum += activeRight(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        cleanNum += activeLeft(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        cleanNum += activeDown(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
                        dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
                    }
                }
            }
        }
        5 -> {
            var cleanNum = _cleanNum
            val map = _map.map { it.copyOf() }.toTypedArray()
            cleanNum += activeUp(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
            cleanNum += activeRight(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
            cleanNum += activeLeft(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
            cleanNum += activeDown(map, n, m, cctvList[cctvIndex].y, cctvList[cctvIndex].x)
            dfs(cctvNum, map, cctvIndex + 1, cleanNum, allMap, n, m)
        }
    }
}

