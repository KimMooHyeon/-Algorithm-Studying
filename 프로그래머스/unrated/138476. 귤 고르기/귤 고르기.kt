data class Tang(val weight: Int, val number : Int)

class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        val hs = HashMap<Int,Int>()
        val tangList = mutableListOf<Tang>()
        var answer: Int = 0
        tangerine.forEach{
            if(hs.containsKey(it)){
                hs[it] =  hs[it]!! +1 
            }else{
                 hs[it] = 1
            }
        }
        hs.forEach{
            tangList.add(Tang(it.key,it.value))
        }
        tangList.sortWith(compareBy({-it.number}))
   
        var num = k
        for(i in 0 until tangList.size ){
            if(num<1){
                break
            }else{
                answer+=1
            }
            num-=tangList[i].number
        }
        return answer
    }
}