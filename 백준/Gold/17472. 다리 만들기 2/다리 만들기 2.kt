import java.io.BufferedReader
import java.io.InputStreamReader

var islandList = mutableSetOf<Int>()
lateinit var map: Array<IntArray>

data class Offset(val i: Int, val j: Int)
data class Edge(val start: Int, val end: Int, val distance: Int)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    map = Array(n) { IntArray(m) }
    val parent = IntArray(n * m) { it }
    val connect = mutableListOf<Edge>()
    repeat(n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        temp.forEachIndexed { index, v ->
            map[it][index] = v
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 1) {
                spreadMap(map, i, j, m, n, parent)
                //     islandList.add(getIndex(i,j,m))
            }
        }
    }
    val hash = HashMap<Int, MutableList<Offset>>()

    islandList.forEach {
        hash[it] = mutableListOf()
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 1) {
                hash[parent[getIndex(i, j, m)]]!!.add(Offset(i, j))
            }
        }
    }
    val islandMutableList = islandList.toMutableList()

    for (i in 0 until islandMutableList.size - 1) {
        for (j in i + 1 until islandMutableList.size) {
            val distance = getMinDistance(islandMutableList[i], islandMutableList[j], hash, parent, m, n)
            //   println("${islandMutableList[i]} ${islandMutableList[j]} distance = ${distance}")
            if (distance == Int.MAX_VALUE) continue
            connect.add(
                Edge(
                    islandMutableList[i],
                    islandMutableList[j],
                    distance
                )
            )
        }
    }
    connect.sortWith(compareBy { it.distance })
    var solSum = -1

    var loadNum = 0
    connect.forEach {
        if (findParent(parent, it.start) != findParent(parent, it.end)) {
            solSum += it.distance
            loadNum += 1
            unionParent(parent, it.start, it.end)
        }
    }

    if (islandList.size - 1 == loadNum) {
        if (solSum == -1) {
            println(solSum)
        } else {
            println(solSum + 1)
        }
    } else {
        println(-1)
    }

}

// 시작할 섬의 좌표들,
fun getMinDistance(a: Int, b: Int, hash: HashMap<Int, MutableList<Offset>>, parent: IntArray, m: Int, n: Int): Int {
    val aList = hash[a]!!
    var smallNum = Int.MAX_VALUE
    aList.forEach {
        val myNum = findParent(parent, getIndex(it.i, it.j, m))
        val xPlusResult = xPlusDfs(myNum, it.i, it.j, b, 0, parent, m, n)
        if (xPlusResult in 2 until smallNum) {
            smallNum = xPlusResult
        }
        val xMinusResult = xMinusDfs(myNum, it.i, it.j, b, 0, parent, m, n)
        if (xMinusResult in 2 until smallNum) {
            smallNum = xMinusResult
        }
        val yPlusResult = yPlusDfs(myNum, it.i, it.j, b, 0, parent, m, n)
        //   println("yPlusResult = ${yPlusResult}")
        if (yPlusResult in 2 until smallNum) {
            smallNum = yPlusResult
        }
        val yMinusResult = yMinusDfs(myNum, it.i, it.j, b, 0, parent, m, n)
        if (yMinusResult in 2 until smallNum) {
            smallNum = yMinusResult
        }
    }
    return if (smallNum > 1) {
        smallNum
    } else {
        -1
    }
}

fun xPlusDfs(myValue: Int, i: Int, j: Int, findParent: Int, num: Int, parent: IntArray, m: Int, n: Int): Int {
    var myNum = -1
    if (findParent(parent, getIndex(i, j, m)) == findParent) {
        return num - 1
    }
    val nextI = i + 1
    if (nextI in 0 until n) {
        if (findParent(parent, getIndex(nextI, j, m)) != myValue || findParent(
                parent,
                getIndex(nextI, j, m)
            ) == findParent
        ) {
            if (map[nextI][j] == 1 && findParent(parent, getIndex(nextI, j, m)) != findParent) {
                return -1
            }
            myNum = xPlusDfs(myValue, nextI, j, findParent, num + 1, parent, m, n)
        } else {
            return -1
        }
    }
    return myNum
}

fun xMinusDfs(myValue: Int, i: Int, j: Int, findParent: Int, num: Int, parent: IntArray, m: Int, n: Int): Int {
    var myNum = -1
    if (findParent(parent, getIndex(i, j, m)) == findParent) {
        return num - 1
    }
    val nextI = i - 1
    if (nextI in 0 until n) {
        if (findParent(parent, getIndex(nextI, j, m)) != myValue || findParent(
                parent,
                getIndex(nextI, j, m)
            ) == findParent
        ) {
            if (map[nextI][j] == 1 && findParent(parent, getIndex(nextI, j, m)) != findParent) {
                return -1
            }
            myNum = xMinusDfs(myValue, nextI, j, findParent, num + 1, parent, m, n)
        } else {
            return -1
        }
    }
    return myNum
}

fun yMinusDfs(myValue: Int, i: Int, j: Int, findParent: Int, num: Int, parent: IntArray, m: Int, n: Int): Int {
    var myNum = -1
    if (findParent(parent, getIndex(i, j, m)) == findParent) {
        return num - 1
    }

    val nextJ = j - 1
    if (nextJ in 0 until m) {
        if (findParent(parent, getIndex(i, nextJ, m)) != myValue || findParent(
                parent,
                getIndex(i, nextJ, m)
            ) == findParent
        ) {
            if (map[i][nextJ] == 1 && findParent(parent, getIndex(i, nextJ, m)) != findParent) {
                return -1
            }
            myNum = yMinusDfs(myValue, i, nextJ, findParent, num + 1, parent, m, n)
        } else {
            return -1
        }
    }
    return myNum
}

fun yPlusDfs(myValue: Int, i: Int, j: Int, findParent: Int, num: Int, parent: IntArray, m: Int, n: Int): Int {

    var myNum = -1
    if (findParent(parent, getIndex(i, j, m)) == findParent) {
        return num - 1
    }
    val nextJ = j + 1
    if (nextJ in 0 until m) {
        if (findParent(parent, getIndex(i, nextJ, m)) != myValue || findParent(
                parent,
                getIndex(i, nextJ, m)
            ) == findParent
        ) {
            if (map[i][nextJ] == 1 && findParent(parent, getIndex(i, nextJ, m)) != findParent) {
                return -1
            }
            myNum = yPlusDfs(myValue, i, nextJ, findParent, num + 1, parent, m, n)
        } else {
            return -1
        }
    }
    return myNum
}

fun findParent(parent: IntArray, x: Int): Int {
    if (x == -1) {
        return -1
    }
    if (parent[x] != x) {
        parent[x] = findParent(parent, parent[x])
    }
    return parent[x]
}

fun unionParent(parent: IntArray, x: Int, y: Int): Int {

    val xParent = findParent(parent, x)
    val yParent = findParent(parent, y)

    if (xParent < yParent) {
        parent[yParent] = xParent
        return parent[yParent]
    } else {
        parent[xParent] = yParent
        return parent[xParent]
    }
}

fun getIndex(x: Int, y: Int, m: Int): Int {
    return x * m + y
}

val xOffset = arrayOf(0, 0, 1, -1)
val yOffset = arrayOf(1, -1, 0, 0)

fun spreadMap(map: Array<IntArray>, i: Int, j: Int, m: Int, n: Int, parent: IntArray) {
    for (index in 0..3) {
        val nextI = i + yOffset[index]
        val nextJ = j + xOffset[index]
        if (nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < m) {
            if (map[nextI][nextJ] == 1) {
                if (findParent(parent, getIndex(nextI, nextJ, m)) != findParent(parent, getIndex(i, j, m))) {
                    islandList.add(unionParent(parent, getIndex(nextI, nextJ, m), getIndex(i, j, m)))
                    spreadMap(map, nextI, nextJ, m, n, parent)
                }
            }
        }
    }
    islandList.add(unionParent(parent, getIndex(i, j, m), getIndex(i, j, m)))
}

fun checkParent(parent: IntArray, m: Int) {
    parent.forEachIndexed { it, v ->
        if (0 == ((it % m)) && it != 0) {
            println()
        }
        print("$v ")
    }
}