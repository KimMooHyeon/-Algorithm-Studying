class Solution {
    fun solution(numbers: IntArray): String {
        val setList = mutableListOf<String>()
        numbers.map{it.toString()}.sortedWith(compareByDescending{ it+it+it }).forEach{
            setList.add(it)
        }
        return if(setList.all { it=="0" }){
            "0"
        }else{
            setList.joinToString("")
        }
            
    }
}