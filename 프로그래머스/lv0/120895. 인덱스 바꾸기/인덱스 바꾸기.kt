class Solution {
    fun solution(my_string: String, num1: Int, num2: Int): String {
        var answer: String = ""
        var myList =my_string.toMutableList().map{it.toString()}.toMutableList()
        var temp = myList[num1]
        myList[num1]= myList[num2]
        myList[num2]=temp
        return myList.joinToString("")
    }
}