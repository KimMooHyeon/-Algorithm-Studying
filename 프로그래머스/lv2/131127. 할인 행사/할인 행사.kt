class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val wantMap = HashMap<String, Int>()
        val newWantMap = HashMap<String, Int>()
        var numIndex = 10

        for (i in number.indices) {
            wantMap[want[i]] = number[i]
            newWantMap[want[i]]=0
        }
        for(i in 0  until numIndex){
         if (wantMap.containsKey(discount[i])) {
            newWantMap[discount[i]] = newWantMap[discount[i]]!! + 1  
         }
        }

        while (true){
    
             if (newWantMap == wantMap){
                answer+=1
            }
                if(numIndex >= discount.size){
                    break
                }
             if(wantMap.containsKey(discount[numIndex-10])){
              newWantMap[discount[numIndex-10]] = newWantMap[discount[numIndex-10]]!!-1   
             }
               if(wantMap.containsKey(discount[numIndex])){
                newWantMap[discount[numIndex]] = newWantMap[discount[numIndex]]!!+1
                }
                 numIndex+=1
            }
          
          //  println("${discount[numIndex-1]}  ${numIndex-1} 끝")
          // println("")
        
    
        return answer
    }
}