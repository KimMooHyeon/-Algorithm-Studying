import java.util.*
class Solution {
    fun solution(gems: Array<String>): IntArray {
        var left =0
        var right =0
        val hs = HashMap<String,Int>()
        val gemsSet = mutableSetOf<String>()
        val myGemsSet = mutableSetOf<String>()
        val result = IntArray(2)
        
        fun checkFinish(): Boolean {
            return gemsSet.size == myGemsSet.size
        }
        gems.forEach{
            gemsSet.add(it)
            hs[it]=0
        }
        for(i in 0 .. gems.size){
           // println("left $left right $right")
            if(checkFinish()){
                if(result[0]==0){
                    result[0]=left+1
                    result[1]=right+1
                }else{
                    if(right-left<result[1]-result[0]){
                        result[0]=left+1
                        result[1]=right+1
                    }
                }
            }
            if(i == gems.size){
               // println("끝")
                break
            }
                right=i
                myGemsSet.add(gems[i])
                hs[gems[i]] = hs[gems[i]]!! +1
           
                if(gems[left] == gems[right] && (left<right)){
                    hs[gems[i]] = hs[gems[i]]!! -1
                    left+=1
                    while(left<right){
                     //   println("$left  =  ${ hs[gems[left]]}")
                        if(hs[gems[left]]!! >1){
                            hs[gems[left]] = hs[gems[left]]!! -1
                            left+=1
                           
                        }else{
                            break
                        }
                    }
                }
            
        }
      
        return result
    }
}