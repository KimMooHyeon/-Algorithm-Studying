class Solution {
    fun solution(age: Int): String {
        var answer: String = ""
       age.toString().toList().forEach{
           answer+= (it.toString().toInt()+97).toChar().toString()
       }

     //   println((2+97).toChar())
        return answer
    }
}