class Solution {
    var hsMap = HashMap<String,Int>()
    fun solution(numbers: String): Long {
        var answer =""
        for(i in 0 .. 9){
            when(i){
                0 ->{
                    hsMap["zero"] = i
                }
                 1 ->{
                    hsMap["one"] = i
                }
                  2 ->{
                    hsMap["two"] = i
                }
                   3 ->{
                    hsMap["three"] = i
                }
                    4 ->{
                    hsMap["four"] = i
                }
                     5 ->{
                    hsMap["five"] = i
                }
                      6 ->{
                    hsMap["six"] = i
                }
                      7 ->{
                    hsMap["seven"] = i
                }
                     8 ->{
                    hsMap["eight"] = i
                }
                      9 ->{
                    hsMap["nine"] = i
                }
            }
        
        }
           println(hsMap.toString())
            var temp = ""
            numbers.forEach{  
                temp+=it.toString()
                if(hsMap.containsKey(temp)){
                    answer+= hsMap[temp]!!.toString()
                    temp=""
                }
            }
        return answer.toLong()
    }
}