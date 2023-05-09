import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

data class Node(val num: Int, val cost: Int)

fun bfs(start: Int, destination: Int, node: Array<MutableList<Node>>, visitNode: BooleanArray): Int {
    val queue = LinkedList<Node>()
    queue.add(Node(start, 0))
    visitNode[start] = false
    var answer = 0

    while (queue.isNotEmpty()) {
        val curQueue = queue.poll()
        if (curQueue.num == destination) {
            return curQueue.cost
        }
        for (i in 0..node[curQueue.num].lastIndex) {
            if (visitNode[node[curQueue.num][i].num]) {
                visitNode[node[curQueue.num][i].num] = false
                queue.add(Node(node[curQueue.num][i].num, node[curQueue.num][i].cost + curQueue.cost))
            }

        }
    }

    return answer
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val node = Array(n + 1) { mutableListOf<Node>() }
    val visitNode = BooleanArray(n + 1) { true }
    repeat(n - 1) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        node[temp[0]].add(Node(temp[1], temp[2]))
        node[temp[1]].add(Node(temp[0], temp[2]))
    }
    repeat(m) {
        val find = br.readLine().split(" ").map { it.toInt() }
        println(bfs(find[0], find[1], node, visitNode.copyOf()))
    }

    br.close()
}
