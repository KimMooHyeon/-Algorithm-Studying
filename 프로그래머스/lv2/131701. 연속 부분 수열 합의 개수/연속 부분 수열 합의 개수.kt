class Solution {
    val setList = mutableSetOf<Int>()
    fun solution(elements: IntArray): Int {
        var tempList = mutableListOf<Int>()
        var answer: Int = 0
        repeat(2){
            elements.forEach{
                tempList.add(it)
            }
        }
        val elementSize= elements.size
       for(size in 1 .. elementSize){
          for (index in 0 until elementSize){
                var sumList = 0
              for (elementIndex in index until index+size){
                  sumList+=tempList[elementIndex]
            }
             // print("$sumList " )
              setList.add(sumList)
          }
       }
     
        return setList.size
    }
}
