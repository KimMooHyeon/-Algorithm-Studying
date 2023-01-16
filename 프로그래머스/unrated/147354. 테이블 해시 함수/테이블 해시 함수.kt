class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
       var answer: Int = 0
       val temp= data.sortedWith(compareBy({it[col-1]},{-it[0]}))
        val resultNum = mutableListOf<Int>()
        for(i in row_begin-1 .. row_end-1 ){
            var tempNum = 0
            temp[i].forEach{
            // println(it)
              tempNum += it%(i+1)
            }
            resultNum.add(tempNum)
        }
        resultNum.forEach{
            answer = answer xor it
        }
       // println(0 xor 2)
       // println(resultNum)
        return answer
    }
}