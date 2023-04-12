class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
          val climb = IntArray(cost.size){0}
          climb[0] = cost[0]
          climb[1] = cost[1]
          for(i in 2 until cost.size){
              climb[i]=minOf(climb[i-1], climb[i-2])+cost[i]
          }
          return minOf(climb[cost.size-1],climb[cost.size-2])
    }
}