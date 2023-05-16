import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun findParent(x: Int, parent: MutableList<Int>): Int {
    if (x != parent[x]) {
        parent[x] = findParent(parent[x], parent)
    }
    return parent[x]
}

fun unionFindParent(x: Int, y: Int, parent: MutableList<Int>,answerHash:HashMap<Int, Int>) {
    val parentX = findParent(x, parent)
    val parentY = findParent(y, parent)
    var xNum = if (parentX in answerHash) answerHash[parentX]!! else 1
    var yNum = if (parentY in answerHash) answerHash[parentY]!! else 1

    if (parentX < parentY) {
        parent[parentY] = parent[parentX]
        answerHash[parent[parentX]]=xNum+yNum

    } else {
        parent[parentX] = parent[parentY]
        answerHash[parent[parentY]]=xNum+yNum
    }
    println(xNum+yNum)
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val tc = br.readLine().toInt()
    repeat(tc) {
        val n = br.readLine().toInt()
        var num = 0
        val hash = HashMap<String, Int>()
        val answerHash = HashMap<Int, Int>()
        val parent = mutableListOf<Int>()
        repeat(n) {
            val temp = br.readLine().split(" ")
            if (temp[0] !in hash) {
                hash[temp[0]] = num
                parent.add(num)
                num += 1
            }
            if (temp[1] !in hash) {
                hash[temp[1]] = num
                parent.add(num)
                num += 1
            }
            if (findParent(hash[temp[0]]!!, parent) != findParent(hash[temp[1]]!!, parent)) {
                unionFindParent(hash[temp[0]]!!, hash[temp[1]]!!, parent,answerHash)
            }else{
                println(answerHash[findParent(hash[temp[0]]!!, parent)]!!)
            }
        }
    }

    bw.close()
    bw.close()
}
