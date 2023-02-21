import java.util.*

class Solution {
    lateinit var start: Pair<Int, Int>
    lateinit var lever: Pair<Int, Int>
    lateinit var end: Pair<Int, Int>
    var xToLever = Int.MAX_VALUE
    var leverToDes = Int.MAX_VALUE
    val xOffeSet = arrayOf(0, 0, 1, -1)
    val yOffeSet = arrayOf(1, -1, 0, 0)
    lateinit var booleanMap1: Array<BooleanArray>
    lateinit var booleanMap2: Array<BooleanArray>

    fun solution(maps: Array<String>): Int {
        var answer: Int = 0
        val map = Array(maps.size) { Array(maps[0].length) { "" } }
        booleanMap1 = Array(maps.size) { BooleanArray(maps[0].length) { true } }
        booleanMap2 = Array(maps.size) { BooleanArray(maps[0].length) { true } }
        maps.forEachIndexed { i, v ->
            val temp = v.toList()
            for (j in 0 until temp.size) {
                map[i][j] = temp[j].toString()
                if (map[i][j] == "S") {
                    start = Pair(i, j)
                }
                if (map[i][j] == "E") {
                    end = Pair(i, j)
                }
                if (map[i][j] == "L") {
                    lever = Pair(i, j)
                }
                if (map[i][j] == "X") {
                    booleanMap1[i][j] = false
                    booleanMap2[i][j] = false
                }
            }
        }
        booleanMap1[start.first][start.second] = false
        bfs(start,  lever, map.map { it })
        if (xToLever == Int.MAX_VALUE) {
            return -1
        } else {
            booleanMap1 = booleanMap2
            booleanMap1[lever.first][lever.second] = false
            bfs(lever,  end, map.map { it })
            if (leverToDes == Int.MAX_VALUE) {
                return -1
            } else {
                return leverToDes + xToLever
            }
        }

        return answer
    }

    fun bfs(start: Pair<Int, Int>, dest: Pair<Int, Int>, map: List<Array<String>>) {
        val queue = LinkedList<Triple<Int, Int, Int>>()
        queue.add(Triple(start.first, start.second, 0))
        while (queue.isNotEmpty()) {
            val temp = queue.pop()
         
            if (dest == lever) {
                if (temp.third >= xToLever) {
                    continue
                }
            } else {
                if (temp.third >= leverToDes) {
                    continue
                }
            }
            if (Pair(temp.first,temp.second) == dest) {
                if (dest == lever) {
                    //  println("도착 $xToLever")
                    if (temp.third < xToLever) {
                        xToLever = temp.third
                        return
                    }
                } else {
                    if (temp.third < leverToDes) {
                       //   println("도착 $leverToDes")
                        leverToDes = temp.third
                        return
                    }
                }
            }

            for (i in 0..3) {
                val nextFirst = temp.first + xOffeSet[i]
                val nextSecond = temp.second + yOffeSet[i]

                if (nextFirst >= 0 && nextFirst < map.size && nextSecond >= 0 && nextSecond < map[0].size) {
                    if (booleanMap1[nextFirst][nextSecond] && map[nextFirst][nextSecond] != "X") {
                        booleanMap1[nextFirst][nextSecond] = false
                        queue.add(Triple(nextFirst, nextSecond, temp.third + 1))
                    }
                }
            }
        }
    }
}