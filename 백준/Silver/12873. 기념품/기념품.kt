import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


// 1단계 : 어떤 참가자의 앞에 서고 하나를 외친다.
//        시계 방향으로 다음 사람에게 이동하며 둘을 외친다.
//         t단계인경우 t3 을 외칠때 까지 진행한다.
// 단계가 끝나면 앞에 서있는 사람은 게임에서 제외 t3을 외칠때 앞에 있던 사람이 제외
// 1단계에서 백준이는 1번 티셔츠를 입은 사람의 앞에 있다.
//원에 한명이 남을때 까지 진행

fun plusNum(num: Long, size: Int): Int {
    if (num * num > size || num * num * num > size) {
        return ((num * num * num) % size).toInt()
    }
    return (num * num * num).toInt()
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val deque = ArrayDeque<Int>()
    //단계
    repeat(n) {
        deque.add(it + 1)
    }
    var num = 0L
    while (deque.size > 1) {
        num += 1

        repeat(plusNum(num, deque.size)) {
            val cur = deque.removeFirst()
            deque.add(cur)
        }
        deque.removeLast()
    }
    println(deque.removeLast())
    br.close()
    bw.close()
}