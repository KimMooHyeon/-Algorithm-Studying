import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var solveNum = 0
lateinit var map: Array<IntArray>
var n = 0
var m = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    //세로 가로
    val (_n, _m) = br.readLine().split(" ").map { it.toInt() }
    n = _n
    m = _m
    map = Array(n) { IntArray(m) }
    repeat(n) {
        br.readLine().split(" ").map { it.toInt() }.forEachIndexed { index, v ->
            map[it][index] = v
            if (v == 1) {
                allCheeseList.add(Pair(it, index))
            }
        }
    }

    startDfs(0, 0)

    var num = 0
    var cheeseNum = 0
    while (true) {
        zeroList.forEach {
            map[it.first][it.second] = -1
        }
        allCheeseList.forEach {
            dfs(it.first, it.second)
        }
        if (deleteList.isNotEmpty()) {
            deleteList.forEach {
                map[it.first][it.second] = -1
                allCheeseList.remove(it)
            }
            zeroList.forEach {
                startDfs(it.first,it.second)
            }
            num += 1
            cheeseNum = deleteList.size
            deleteList.clear()
            zeroList.clear()
        } else {
            break
        }
      //  printMap()
    }

    bw.write("${num}\n${cheeseNum}")

    br.close()
    bw.close()
}

fun dfs(i: Int, j: Int) {
    val temp = mutableSetOf<Pair<Int,Int>>()
    var flag = false
    for (k in 0..3) {
        val newI = i + iOffset[k]
        val newJ = j + jOffset[k]
        if (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
            if (map[newI][newJ] == -1) {
                deleteList.add(Pair(i, j))
                flag=true
            }else if(map[newI][newJ] == 0){
                temp.add(Pair(newI,newJ))
            }
        }
        if (flag){
            zeroList.addAll(temp)
        }
    }
}

var allCheeseList = mutableSetOf<Pair<Int, Int>>()
var cheeseList = mutableSetOf<Pair<Int, Int>>()
var deleteList = mutableSetOf<Pair<Int, Int>>()
var zeroList = mutableSetOf<Pair<Int, Int>>()

val iOffset = arrayOf(0, 0, 1, -1)
val jOffset = arrayOf(1, -1, 0, 0)

fun startDfs(i: Int, j: Int) {
    if (map[i][j] == 0) {
        map[i][j] = -1
    } else if (map[i][j] == 1) {
        cheeseList.add(Pair(i, j))
        return
    } else {
        return
    }
    for (k in 0..3) {
        val newI = i + iOffset[k]
        val newJ = j + jOffset[k]
        if (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
            startDfs(newI, newJ)
        }
    }
}
fun printMap(){
    for (i in 0 until n){
        for (j in 0 until m){
            if (map[i][j]==-1){
                print("  ")
            }else{
                print("${map[i][j]} ")
            }
        }
        println()
    }
}