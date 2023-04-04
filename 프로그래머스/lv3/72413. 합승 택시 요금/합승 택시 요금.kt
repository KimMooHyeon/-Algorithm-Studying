import java.util.*
class Solution {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer: Int = Integer.MAX_VALUE
        val map = Array(n+1){IntArray(n+1){Integer.MAX_VALUE}}
        fares.forEach{
           if (map[it[0]][it[1]] >it[2]){
               map[it[0]][it[1]] = it[2]
               map[it[1]][it[0]] = it[2]
           }
        }
        for (k in 0 .. n){
            for (i in 0 .. n){
                for (j in 0 .. n){
                    if(i != j){
                        if(map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE){
                             if(map[i][j]>map[i][k]+map[k][j]){
                            map[i][j] = map[i][k]+map[k][j]
                            map[j][i] = map[i][k]+map[k][j]
                         }
                        }      
                    }
                }
            }
        }
        for (i in (1..n)){
            map[i][i] = 0
        }
 
       
        for (i in (1..n)){
           // println(i)
        
               // println("${map[s][i]} ${map[i][a]} ${map[i][b]}")
                if( map[i][a] != Integer.MAX_VALUE && map[i][b] != Integer.MAX_VALUE && map[s][i] != Integer.MAX_VALUE  ){
                var smallNum = map[s][i] + map[i][a] + map[i][b]
                if(answer>smallNum){
                    answer=smallNum
                }
               }
            
        }
        return answer
    }
}