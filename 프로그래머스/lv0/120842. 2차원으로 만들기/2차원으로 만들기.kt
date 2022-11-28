class Solution {
    fun solution(num_list: IntArray, n: Int): ArrayList<IntArray> {
        var answer: ArrayList<IntArray> = arrayListOf<IntArray>()
        for(i in 0 until num_list.size-n+1 step n){
            var tempList = mutableListOf<Int>()
            for(j in i until i+n){
                tempList.add(num_list[j])
            }
            answer.add(tempList.toIntArray())
        }
        return answer
    }
}