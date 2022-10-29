class Solution {
    fun solution(array: IntArray): Int {
        var answer: Int = 0
        val hash = array.groupBy{it}.map{it.value.size to it.key}.sortedByDescending{it.first}
        if(hash.size == 1){
            return hash[0].second
        }else if (hash[0].first == hash[1].first){
            return -1
        }else{
            return hash[0].second
        }
     
    }
}