class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = clothes.groupBy { it[1] }.values.fold(1) { total, next ->
            total * (next.size+1)
        } -1

        return answer
    }
}