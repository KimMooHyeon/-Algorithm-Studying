class Solution {
    fun solution(emergency: IntArray): ArrayList<Int> {
        var answer = arrayListOf<Int>()
        var emergencySorted =emergency.sortedDescending()
        emergency.forEach{
            answer.add(emergencySorted.indexOf(it)+1)
        }
        return answer
    }
}