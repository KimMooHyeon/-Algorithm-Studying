class Solution {
    fun solution(lines: Array<IntArray>): Int {
        var answer = 0;
        val map =  HashMap<Int,Int>()

        for ( i  in lines.indices) {
            val min = lines[i][0].coerceAtMost(lines[i][1])
            val max = lines[i][0].coerceAtLeast(lines[i][1])

            for ( j in min until max) {
                map[j] = map.getOrDefault(j, 0) + 1;
            }
        }
        
        map.values.forEach {value ->
            if (value > 1) answer++;
        }

        return answer
    }
}