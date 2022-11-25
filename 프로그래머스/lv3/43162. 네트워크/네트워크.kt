class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        var booleanArray = BooleanArray(n){true}
        var computerNetworkEdge = Array<ArrayList<Int>>(n){ArrayList()}
        computers.forEachIndexed{ i,v->
            v.forEachIndexed{index,connect->
                if(connect==1){
                    computerNetworkEdge[i].add(index)
                }
            }
        }
    
        fun dfs(index : Int){
           if(booleanArray[index]){
               booleanArray[index]=false
               computerNetworkEdge[index].forEachIndexed{ i,v->
                     dfs(v)
               }
           }
        }
         for(i in 0 until n){
             if(booleanArray[i]){
                 answer+=1
                   dfs(i)
             }        
           }
        return answer
    }
}