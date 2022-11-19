import kotlin.math.sqrt

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0
        for(i in 1 .. number){
            var num =measure(i)
            if(num>limit){
                answer+=power
            }else{
                answer+=num
            }
        }
        return answer
    }
    fun measure(number : Int ) : Int{
        var numSet = mutableSetOf<Int>()
        if(number == 1){
           return 1
        }else{
          for(i in 1 .. number/2){
              if(number%i == 0){
                  numSet.add(number%i)
                  numSet.add(number/i)
              }
          }
        }
        return numSet.size
    }
}