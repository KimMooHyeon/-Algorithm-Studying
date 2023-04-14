// 1 2 3 4 5
// 2, 1, 2, 3, 2, 4, 2, 5
// 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,

class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        val oneAnswer = listOf(1,2,3,4,5)
        val twoAnswer = listOf(2, 1, 2, 3, 2, 4, 2, 5)
        val threeAnswer = listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        var one = 0
        var two = 0
        var three = 0
        answers.forEachIndexed{ i, v ->
            if(oneAnswer[i%5]==v){
                one+=1
            }
            if(twoAnswer[i%8]==v){
                two+=1
            }
            if(threeAnswer[i%10]==v){
                three+=1
            }
        }
        var maxNum = maxOf(one,two,three)
        if(maxNum == one){
            answer.add(1)
        }
        if(maxNum == two){
            answer.add(2)
        }
        if(maxNum == three){
            answer.add(3)
        }
        return answer.toIntArray()
    }
}