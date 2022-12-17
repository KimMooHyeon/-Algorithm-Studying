class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray =IntArray(s.length){0}
        val hsMap =HashMap<Char,Int>()
        s.forEachIndexed{ i,v ->
            if(hsMap.containsKey(v)){
                answer[i]= i - hsMap[v]!!
                hsMap[v]=i
            }else{
                answer[i]=-1
                hsMap[v]=i
            }
            
        }
        return answer
    }
}