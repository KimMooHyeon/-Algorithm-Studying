import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val plusSet = PriorityQueue<Int>()
    val minusSet = PriorityQueue<Int>()

   for (i in 1 .. N){
        val num = br.readLine().toInt()
        if (num != 0){
            if (num<0){
                minusSet.offer(-num)
            }else{
                plusSet.offer(num)
            }
            //배열에 x라는 값을 넣는(추가하는) 연산이고,
        }else{
            if (minusSet.isEmpty() && plusSet.isEmpty()){
                bw.write("0\n")
            }else if (minusSet.isEmpty()){
                val minNum = plusSet.poll()
                bw.write("${minNum}\n")
            }else if (plusSet.isEmpty()){
                val minNum = minusSet.poll()
                bw.write("${-minNum}\n")
            }else{
                val plusMinNum = plusSet.peek()
                val minusMinNum = minusSet.peek()
               if (minusMinNum <= plusMinNum){
                   bw.write("${-minusMinNum}\n")
                   minusSet.poll()
               }else{
                   plusSet.poll()
                   bw.write("${plusMinNum}\n")
               }
            }
            //약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
            //x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이
        }
    }
    br.close()
    bw.close()
}


