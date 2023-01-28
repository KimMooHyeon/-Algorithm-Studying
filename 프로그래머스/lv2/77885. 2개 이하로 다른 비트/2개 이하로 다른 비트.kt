class Solution {
    fun solution(numbers: LongArray): LongArray {
        val answer = LongArray(numbers.size)
        numbers.map { n ->
            (n.inv() and n + 1).let { n or it and (it shr 1).inv() }
        }.forEachIndexed { i, v ->
            answer[i] = v
        }
        return answer
    }
}