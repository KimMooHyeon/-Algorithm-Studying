class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): ArrayList<Int> {
        var answer = arrayListOf<Int>()
        commands.forEach{intArray->
           answer.add(array.toMutableList().subList(intArray[0]-1,intArray[1]).sorted()[intArray[2]-1])
        }
        return answer
    }
}