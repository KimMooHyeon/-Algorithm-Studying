import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val pro = br.readLine()
    val bomb = br.readLine()
    val stack = Stack<Char>()
    var index:Long = 0
    val maxBomb :Long= bomb.length - 1L
    val bombSize :Long= bomb.length.toLong()
    for (i in 0 until pro.length) {

        stack.push(pro[i])

       // println("시작 ${pro[i]}")
      //  println("${pro[i]} == ${bomb[index]}")
        if (pro[i] == bomb[index.toInt()]) {
            if (maxBomb == index) {
                repeat(bombSize.toInt()){
                    stack.pop()
                }
                if (stack.isEmpty()){
                    index = 0
                }else{
                  //  println(stack.peek())
                    if (stack.peek() !in bomb){
                        index=0
                    }else{
                        val lastIndex = bomb.indexOf(stack.peek())
                        var checkIndex = bomb.indexOf(stack.peek())
                        var resetFlag =false
                        for (i in stack.lastIndex downTo  stack.lastIndex-lastIndex){
                            if (i<0){
                                break
                            }else{
                                if(stack[i] != bomb[checkIndex]){
                                    resetFlag=true
                                    break
                                }else{
                                    checkIndex-=1
                                }
                            }
                        }
                    if (resetFlag){
                        index=0
                    }else{
                        index = bomb.indexOf(stack.peek())+1L
                    }

                        if (index>maxBomb+1){
                            index=0
                        }
                    }

                }
            } else {
                index += 1
            }
        } else {
            index = 0
            if (pro[i] == bomb[index.toInt()]){
                index+=1
            }
        }
      //  println("인덱스 $index")
    }
    if (stack.isEmpty()){
        println("FRULA")
    }else{
        println(stack.joinToString(""))
    }
    br.close()
}
