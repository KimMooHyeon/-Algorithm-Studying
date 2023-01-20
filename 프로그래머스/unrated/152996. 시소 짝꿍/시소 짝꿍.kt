import java.util.*
var flag= false
val hs = HashMap<Int,Int>()
class Solution {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0
        weights.sort()
        for(i in 0 until weights.size-1 ){
             if(hs.containsKey(weights[i])){
                 hs[weights[i]] = hs[weights[i]]!!-1
                 answer+= hs[weights[i]]!!
                 continue
             }
             var tempNum = 0
            for(j in i+1 until weights.size){
           
                if(check(weights[i],weights[j])){
                    tempNum+=1
                }
                if(flag){
                    flag=false
                    break
                }
            }
            answer+=tempNum
            hs[weights[i]]= tempNum
        }
        return answer
    }
}
fun check(small:Int,big:Int):Boolean{
    if(small == big){
        return true
    }
    val a = listOf(Pair(4,2),Pair(3,2),Pair(4,3))
    for(i in 0 .. 2){
            var aTemp = small * a[i].first
            var bTemp = big * a[i].second
            if(aTemp == bTemp){
             //   println("$small $big")
                return true
            }else if(aTemp<bTemp){
                if(i==0){
                    flag=true    
                }
                return false
              //  println("$small $big , ${aTemp} ${bTemp}")
        }
    }
    return false
}