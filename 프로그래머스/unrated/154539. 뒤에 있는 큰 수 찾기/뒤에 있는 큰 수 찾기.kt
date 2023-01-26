import java.util.*

class Solution {
    fun solution(numbers: IntArray): MutableList<Int> {
        val answer = mutableListOf<Int>()
        val stack = Stack<Int>()
        val queue = Stack<Int>()
        val maxList = Stack<Int>()
        numbers.forEach {
            stack.add(it)
        }

        queue.add(-1)
        maxList.add(stack.pop())

        while (stack.isNotEmpty()) {
            val num = stack.pop()
         
            if (num < maxList.peek()) {
                queue.add(maxList.peek())
                maxList.add(num)
            } else {
                while (maxList.isNotEmpty()) {
                    val temp = maxList.pop()
                    if (temp > num) {
                        queue.add(temp)
                        maxList.add(temp)
                        maxList.add(num)
                        break
                    }
                }
                if (maxList.isEmpty()) {
                    maxList.add(num)
                    queue.add(-1)
                }
            }
        }
        while (queue.isNotEmpty()) {
            val num = queue.pop()
            answer.add(num)
        }
        return answer
    }
}