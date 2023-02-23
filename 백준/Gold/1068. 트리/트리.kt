import java.io.BufferedReader
import java.io.InputStreamReader

fun deleteNode(deleteNumber: Int, nodeMap: HashMap<Int, MutableList<Int>>) {
    if (nodeMap[deleteNumber]!!.isEmpty()) {
        return
    } else {
        nodeMap[deleteNumber]!!.forEach {
            deleteNode(it, nodeMap)
        }
        nodeMap[deleteNumber] = mutableListOf(-1)
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nodeNumber = br.readLine().toInt()
    val nodeList = br.readLine().split(" ").map { it.toInt() }
    val deleteNumber = br.readLine().toInt()
    var rootNumber = 0
    val hash = HashMap<Int, MutableList<Int>>()
    for (i in 0 until nodeNumber) {
        hash[i] = mutableListOf()
    }
    var sol = 0
    nodeList.forEachIndexed { i, v ->
        if (v == -1) {
            rootNumber = i
        }
        if (v != -1 && deleteNumber != i) {
            hash[v]!!.add(i)
        }
    }

    deleteNode(deleteNumber, hash)

    hash.values.forEach {
        if (it.isNotEmpty()) {
            if (it[0] != -1) {
                for (i in 0 until it.size) {
                    if (hash[it[i]]!!.isEmpty()) {
                        sol += 1
                    }
                }
            }
        }
    }
    if (deleteNumber != rootNumber && hash[rootNumber]!!.isEmpty()) {
        sol += 1
    }
    println(sol)

}