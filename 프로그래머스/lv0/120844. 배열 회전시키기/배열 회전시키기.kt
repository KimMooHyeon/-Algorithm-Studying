class Solution {
    fun solution(numbers: IntArray, direction: String): IntArray {
        var answer: IntArray = intArrayOf()
        val tempList= mutableListOf<Int>()
        numbers.forEach{
            tempList.add(it)
        }
        if(direction == "right"){
            tempList.add(0,tempList[tempList.lastIndex])
            tempList.removeAt(tempList.lastIndex)
        }else{
            tempList.add(tempList[0])
            tempList.removeAt(0)
        }
        return tempList.toIntArray()
    }
}