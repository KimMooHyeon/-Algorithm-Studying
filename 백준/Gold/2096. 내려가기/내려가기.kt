import java.io.BufferedReader
import java.io.InputStreamReader

fun mindp(
    row: Int,
    colum: Int,
    minMap: Array<IntArray>,
    map: Array<List<Int>>
): Int {
    if (row == 0) {
        return map[row][colum]
    }
    if (minMap[row][colum] != Int.MAX_VALUE) {
        return minMap[row][colum]
    }
    when (colum) {
        0 -> {
            minMap[row][colum] = minOf(mindp(row - 1, 0, minMap, map), mindp(row - 1, 1, minMap, map)) + map[row][colum]
        }
        1 -> {
            minMap[row][colum] = minOf(
                mindp(row - 1, 0, minMap, map),
                mindp(row - 1, 1, minMap, map),
                mindp(row - 1, 2, minMap, map)
            ) + map[row][colum]
        }
        2 -> {
            minMap[row][colum] = minOf(mindp(row - 1, 1, minMap, map), mindp(row - 1, 2, minMap, map)) + map[row][colum]
        }
        else -> {}
    }
    return minMap[row][colum]
}

fun maxdp(
    row: Int,
    colum: Int,
    maxMap: Array<IntArray>,
    map: Array<List<Int>>
): Int {
    if (row == 0) {
        return map[row][colum]
    }
    if (maxMap[row][colum] != Int.MIN_VALUE) {
        return maxMap[row][colum]
    }
    when (colum) {
        0 -> {
            maxMap[row][colum] = maxOf(maxdp(row - 1, 0, maxMap, map), maxdp(row - 1, 1, maxMap, map)) + map[row][colum]
        }
        1 -> {
            maxMap[row][colum] = maxOf(
                maxdp(row - 1, 0, maxMap, map),
                maxdp(row - 1, 1, maxMap, map),
                maxdp(row - 1, 2, maxMap, map)
            ) + map[row][colum]
        }
        2 -> {
            maxMap[row][colum] = maxOf(maxdp(row - 1, 1, maxMap, map), maxdp(row - 1, 2, maxMap, map)) + map[row][colum]
        }
        else -> {}
    }
    return maxMap[row][colum]
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val num = br.readLine().toInt()
    val map = Array(num) { listOf<Int>() }
    val minMap = Array(num) { IntArray(3) { Int.MAX_VALUE } }
    val maxMap = Array(num) { IntArray(3) { Int.MIN_VALUE } }

    repeat(num) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        map[it] = temp
    }
    repeat(3) {
        minMap[0][it] = map[0][it]
        maxMap[0][it] = map[0][it]
    }
    mindp(num - 1, 0, minMap, map)
    mindp(num - 1, 1, minMap, map)
    mindp(num - 1, 2, minMap, map)

    maxdp(num - 1, 0, maxMap, map)
    maxdp(num - 1, 1, maxMap, map)
    maxdp(num - 1, 2, maxMap, map)

    println("${maxOf(maxMap[num-1][0],maxMap[num-1][1],maxMap[num-1][2])} ${minOf(minMap[num-1][0],minMap[num-1][1],minMap[num-1][2])}")
}
