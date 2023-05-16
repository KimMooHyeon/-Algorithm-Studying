import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun findParent(x: Int, parent: IntArray): Int {
    if (x != parent[x]) {
        parent[x] = findParent(parent[x], parent)
    }
    return parent[x]
}

fun unionFindParent(x: Int, y: Int, parent: IntArray) {
    val parentX = findParent(x, parent)
    val parentY = findParent(y, parent)
    if (parentX < parentY) {
        parent[parentY] = parent[parentX]
    } else {
        parent[parentX] = parent[parentY]
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val map = Array(n) { mutableListOf<Int>() }
    val parent = IntArray(n) { it }

    repeat(n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        map[it] = temp.toMutableList()
    }
    val tripList = br.readLine().split(" ").map { it.toInt() }
    map.forEachIndexed { i, v ->
        for (index in i + 1..v.lastIndex) {
            if (v[index] == 1) {
                if (findParent(i, parent) != findParent(index, parent)) {
                    unionFindParent(i, index, parent)
                }
             //   println(parent.contentToString())
            }
        }
    }
    var errorFlag = false
    repeat(n){
        findParent(it,parent)
    }
    val startNum = parent[tripList[0] - 1]

    for (i in 1..tripList.lastIndex) {
        if (parent[tripList[i] - 1] != startNum) {
            errorFlag = true
            break
        }
    }

    if (errorFlag) {
        println("NO")
    } else {
        println("YES")
    }
   // println(parent.contentToString())
    bw.close()
    bw.close()
}
