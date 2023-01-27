class Solution {
    lateinit var map: Array<IntArray>
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = IntArray(queries.size)
        map = Array(rows) { IntArray(columns) }
        var num = 1
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                map[i][j] = num
                num += 1

            }

        }
     
        queries.forEachIndexed{ i,v->
            answer[i]= query(v)
        }

        return answer
    }

    fun query(queries: IntArray): Int {

        // 0 ,0
        // 99 , 96

        // 0 1 // 1 2
        val y1 = queries[0] - 1 // 0
        val x1 = queries[1] - 1 //0
        val y2 = queries[2] - 1 // 99
        val x2 = queries[3] - 1  //96
        val start = map[y1][x1]
        var small = start
        //x1 고정 y2에서 y1 역순
        for (y in y1 .. y2 - 1) {
            map[y][x1] = map[y+1][x1]
            if (map[y][x1] < small) {
                small = map[y][x1]
            }
        }
        // y2고정 x +
        for (x in x1 .. x2 - 1) {
            map[y2][x] = map[y2][x+1]
            if (map[y2][x] < small) {
                small = map[y2][x]
            }
        }
        //x2 고정 y2에서 y1 역순
        for (y in y2 downTo y1 +1) {
            map[y][x2] = map[y-1][x2]
            if (map[y][x2] < small) {
                small = map[y][x2]
            }
        }
        for (x in x2 downTo x1 + 1) {
            map[y1][x] = map[y1][x-1]
            if (map[y1][x] < small) {
                small = map[y1][x]
            }
        }
        map[y1][x1+1]=start
        return small
    }
}

fun main() {

    val temp =Solution()
    temp.solution(100,97, arrayOf(intArrayOf(1,1,100,97)))
}