import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Deque
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue
import java.util.Stack

data class Pos(val p: Int,val time: Int,val before:Int?=null)

lateinit var visited: BooleanArray
lateinit var newVisited: BooleanArray
lateinit var dp: IntArray
lateinit var check: IntArray
lateinit var parent: IntArray
var answer = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val queue = PriorityQueue<Pos> { p1, p2 -> p1.time - p2.time }
    visited = BooleanArray(100001) { false }
    newVisited = BooleanArray(100001) { true }
    dp = IntArray(100001) { Int.MAX_VALUE }
    check = IntArray(100001) { 0 }
    parent = IntArray(100001) { -1 }
    val temp = ArrayDeque<Int>()
    temp.add(n)
    queue.offer(Pos(n, 0))
    dp[n] = 0
    visited[n] = true
    while (queue.isNotEmpty()) {
        val next = queue.poll()
        visited[next.p] = true
        if (dp[next.p] == Int.MAX_VALUE) {
            dp[next.p] = next.time
            check[next.p] = 1
            parent[next.p]=next.before!!
        } else if (dp[next.p] < next.time) {
            continue
        } else if (dp[next.p] == next.time) {
            check[next.p] += 1
        } else {
            check[next.p] = 1
            parent[next.p]=next.before!!
        }
        if (next.p == k) {
            answer = next.time
            println(next.time)
            break
        }

        if (next.p * 2 < 100001 && !visited[next.p * 2]) {
            queue.offer(Pos(next.p * 2, next.time + 1,next.p))
        }
        if (next.p + 1 < 100001 && !visited[next.p + 1]) {
            temp.add(next.p + 1)
            queue.offer(Pos(next.p + 1, next.time + 1,next.p))
        }
        if (next.p - 1 >= 0 && !visited[next.p - 1]) {
            temp.add(next.p - 1)
            queue.offer(Pos(next.p - 1, next.time + 1,next.p))
        }
    }
    var nextNum = k
    val stack = Stack<Int>()
    while (true) {
        stack.push(nextNum)
        if (nextNum == n) {
            break
        }
        nextNum = parent[nextNum]
    }
    while (stack.isNotEmpty()){
        print("${stack.pop()} ")
    }
}
