import java.util.*

class Solution {
       lateinit var  bm :BooleanArray
       lateinit var  mapArray :Array<MutableList<Int>>
       lateinit var  intMap :IntArray
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        bm = BooleanArray(n+1){true}
        mapArray = Array(n+1){mutableListOf<Int>()}
        intMap = IntArray(n+1){-1}
        edge.forEach{
            mapArray[it[0]].add(it[1])
            mapArray[it[1]].add(it[0])
        }
    
        
        dfs(1,0)
        val maxNum=intMap.maxOrNull()
        intMap.forEach{
            if(it == maxNum) answer+=1
        }
      //  println(Arrays.toString(intMap))
      //  println(Arrays.toString(mapArray))
     //   println(Arrays.toString(bm))
        return answer
    }
    fun dfs(startNode:Int,depth:Int){
        bm[startNode]=false
        if(intMap[startNode] == -1){
            intMap[startNode] = depth
        }else{
            if(intMap[startNode]>depth){
                intMap[startNode]=depth
            }
        }
        mapArray[startNode].forEach{
          //  println("$it depth = $depth bm[it] = ${bm[it]}")
            if(intMap[it]==-1 || intMap[it]>depth+1) {
                 dfs(it,depth+1)
                // bm[it]=true
            }
        }
    }
}