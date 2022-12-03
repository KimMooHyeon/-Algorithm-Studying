import java.util.*
class Solution {
    fun solution(my_string: String): Int {
        var sum: Int = 0
        var index = 0
        val temp =my_string.split(" ").map{it.toString()}
        while(index <temp.size){
            when(temp[index]){
                 "-"->{
                     index+=1
                     sum-=temp[index].toInt()
                     index+=1
                 }
                  "+"->{
                     index+=1
                     sum+=temp[index].toInt()
                     index+=1
                 }
                  else->{
                     sum+=temp[index].toInt()
                     index+=1
                  }
             }
           }

        return sum
    }
}