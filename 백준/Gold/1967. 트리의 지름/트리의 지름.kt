import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

data class Node(val destination: Int, val cost: Int)

var answer = 0
var startNode = 0

fun dijkstra(start: Int, nodeList: Array<MutableList<Node>>, distance: IntArray) {
    distance[0] = 0
    distance[start] = 0
    val queue = LinkedList<Node>()
    queue.add(Node(start, 0))
    while (queue.isNotEmpty()) {
        val curNum = queue.poll()
        for (i in 0..nodeList[curNum.destination].lastIndex) {
            val nextIndex = nodeList[curNum.destination][i].destination
            if (distance[nextIndex] > nodeList[curNum.destination][i].cost + curNum.cost) {
                distance[nextIndex] = nodeList[curNum.destination][i].cost + curNum.cost
                queue.add(Node(nextIndex, nodeList[curNum.destination][i].cost + curNum.cost))
            }
        }
    }

    answer = maxOf(answer, distance.max())
}
fun bfs(start:Int, treeList:Array<MutableList<Node>>){
    var maxNum = 0
    val queue = LinkedList<Node>()
    queue.add(Node(start, 0))
    while (queue.isNotEmpty()){
        val curNode= queue.poll()
        if (treeList[curNode.destination].size ==0){
            //리프노드
            if (maxNum<curNode.cost){
                maxNum=curNode.cost
                startNode=curNode.destination
            }
        }else{
            for (i in 0 .. treeList[curNode.destination].lastIndex){
                queue.add(Node(treeList[curNode.destination][i].destination,treeList[curNode.destination][i].cost+curNode.cost))
            }
        }
    }
}
val childHash = HashMap<Int, Boolean>()
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val num = br.readLine().toInt()
    val distance = IntArray(num + 1) { Int.MAX_VALUE }
    val nodeList = Array(num + 1) { mutableListOf<Node>() }
    val treeList = Array(num + 1) { mutableListOf<Node>() }
    repeat(num - 1) {
        val (A, B, C) = br.readLine().split(" ").map { it.toInt() }
        childHash[B] = true
        val node = Node(B, C)
        treeList[A].add(node)
        nodeList[A].add(node)
        nodeList[B].add(Node(A, C))
    }
    var parentNum = 0
    for (i in 1..num) {
        if (i !in childHash) {
            parentNum = i
            break
        }
    }
    bfs(parentNum,treeList)
    dijkstra(startNode, nodeList, distance.copyOf())
    if (num ==1){
        println(0)
    }else{
        println(answer)
    }
    //bw.write(ans.toString())
    bw.close()
    bw.close()
}
