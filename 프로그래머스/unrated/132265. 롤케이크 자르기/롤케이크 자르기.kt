import java.util.*
class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        val aSet = mutableSetOf<Int>()
        val bSet = mutableSetOf<Int>()
        val aHsMap = HashMap<Int,Int>()
        val bHsMap = HashMap<Int,Int>()
        
        for(i in 0 until topping.size){
           if(i==0){
               aSet.add(topping[i])
               aHsMap[topping[i]]=1
               bHsMap[topping[i]]=0
           }else{
               aHsMap[topping[i]]=0
               bSet.add(topping[i])
               if(bHsMap.containsKey(topping[i])){
                    bHsMap[topping[i]] = bHsMap[topping[i]]!! + 1
               }else{
                    aHsMap[topping[i]] = 0
                    bHsMap[topping[i]] = 1
               }
           }
        }
       for(i in 1 until topping.size){
            if(aSet.size == bSet.size){
                answer+=1
            }
            aSet.add(topping[i])
            bHsMap[topping[i]] = bHsMap[topping[i]]!! - 1
           if( bHsMap[topping[i]]!! == 0 ){
               bSet.remove(topping[i])
           }
       }
       
        return answer
    }
}