import java.util.Arrays
import java.util.PriorityQueue

data class Edge(val a:Int,val b:Int,val cost:Int): Comparable<Edge>{
    override fun compareTo(other:Edge) = cost-other.cost
}

class Solution {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        val parent = IntArray(n){it}
        val queue = PriorityQueue<Edge>()

        costs.forEach{
            queue.add(Edge(it[0],it[1],it[2]))
        }
        var num = 0
        while(queue.isNotEmpty()){
           val edge = queue.poll()
           if(findParent(parent,edge.a)!=findParent(parent,edge.b)){
               unionParent(parent,edge.a,edge.b)
               num+=1
               println(edge.cost)
               answer+=edge.cost
           }
           if(num == n-1){
               break
           }
        }
        println(Arrays.toString(parent))
        return answer
    }

    fun findParent(parent:IntArray,n:Int):Int {
        if(parent[n] != n){
            parent[n] = findParent(parent,parent[n])
        }
        return parent[n]
    }
    fun unionParent(parent:IntArray,a:Int,b:Int){
        val aParent = findParent(parent,a)
        val bParent = findParent(parent,b)
        
        if(aParent < bParent){
            parent[bParent] = aParent
        }else{
            parent[aParent] = bParent
        }
    }
}