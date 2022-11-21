
class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0
        var bigList = mutableListOf<Int>()
        var smallList = mutableListOf<Int>()
        sizes.forEach{
            if(it[1]>=it[0]){
                bigList.add(it[1])
                smallList.add(it[0])
            }else{
                bigList.add(it[0])
                smallList.add(it[1])
            }
        }
        return bigList.maxOrNull()!!*smallList.maxOrNull()!!
    }
}