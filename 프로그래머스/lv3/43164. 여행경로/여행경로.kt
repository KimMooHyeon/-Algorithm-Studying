data class Ticket (val dest : String, var using :Boolean = false)
class Solution {
    var ticketSum : Int = 0
    var flag = false
    var ticktetHashMap=HashMap<String,ArrayList<Ticket>>()
    var answer = listOf<String>()
    fun solution(tickets: Array<Array<String>>): List<String> {
        ticketSum = tickets.size
        val ticketsSort = tickets.sortedWith(compareBy<Array<String>>{it[0]}.thenBy{it[1]})
         ticketsSort.forEach{
             if(ticktetHashMap.containsKey(it[0])){
                 ticktetHashMap[it[0]]!!.add(Ticket(it[1]))
            }else{
               ticktetHashMap[it[0]] = arrayListOf(Ticket(it[1]))
          }
      }
    
         dfs("ICN",0,arrayListOf<String>())
        return answer
    }
    fun dfs(start : String , usingNum: Int,res : ArrayList<String>) {
     //   print("usingNum = $usingNum ")
    //    println(res)
       // check()
        if(flag){
            return
        }
        if(ticktetHashMap.containsKey(start)){
         ticktetHashMap[start]!!.forEach{
            // println("start = $start it.dest = ${it.dest}")
            if(!it.using){
                res.add(start) // C00
                it.using = true
                dfs(it.dest,usingNum+1,res)
                res.removeLast()
                it.using = false
            }
         }
        }
        if(usingNum==ticketSum){
            res.add(start)
           answer = res.map{it}
           flag=true
        //   println("finish ${res}")
        }
        
    }
    fun check(){
     ticktetHashMap.forEach{
            println(it)
      }
    }
}