import java.util.*

data class Point(val dis: String, val y: Int, val x: Int)

data class MapPoint(var y: Int, var x: Int, var sum: Int)

val hash = HashMap<Point, Int>()
var answer = Int.MAX_VALUE

fun bfs(board: Array<String>) {
    val queue = LinkedList<MapPoint>()
    var endY = 0
    var endX = 0
    var end1Flag = false
    var end2Flag = false
    for (i in 0..board.lastIndex) {
        for (j in 0..board[0].lastIndex) {
            if (end1Flag && end2Flag) {
                break
            }
            if (board[i][j] == 'R') {
                queue.add(MapPoint(i, j, 0))
                end1Flag = true
            }
            if (board[i][j] == 'G') {
                endY = i
                endX = j
                end2Flag = true
            }
        }
    }
    while (queue.isNotEmpty()) {
        val curPoint = queue.poll()
        if (answer != Int.MAX_VALUE) {
            if (curPoint.sum >= answer) {
                continue
            }
        }
        if (curPoint.y == endY && curPoint.x == endX) {
            answer = minOf(answer, curPoint.sum)
        } else {
            val leftStartPoint = Point("left", curPoint.y, curPoint.x)
            if (leftStartPoint !in hash) {
                hash[leftStartPoint] = curPoint.sum
                var findFlag = true
                for (x in curPoint.x - 1 downTo 0) {
                    if (board[curPoint.y][x] == 'D') {
                        queue.add(MapPoint(curPoint.y, x + 1, curPoint.sum + 1))
                        findFlag = false
                        break
                    }
                }
                if (findFlag) {
                    queue.add(MapPoint(curPoint.y, 0, curPoint.sum + 1))
                }
            } else {
                if (hash[leftStartPoint]!! > curPoint.sum) {
                    hash[leftStartPoint] = curPoint.sum
                    var findFlag = true
                    for (x in curPoint.x - 1 downTo 0) {
                        if (board[curPoint.y][x] == 'D') {
                            queue.add(MapPoint(curPoint.y, x + 1, curPoint.sum + 1))
                            findFlag = false
                            break
                        }
                    }
                    if (findFlag) {
                        queue.add(MapPoint(curPoint.y, 0, curPoint.sum + 1))
                    }
                }
            }
        }

        val rightStartPoint = Point("right", curPoint.y, curPoint.x)
        if (rightStartPoint !in hash) {
            hash[rightStartPoint] = curPoint.sum
            var findFlag = true
            for (x in curPoint.x + 1..board[curPoint.y].lastIndex) {
                if (board[curPoint.y][x] == 'D') {
                    queue.add(MapPoint(curPoint.y, x - 1, curPoint.sum + 1))
                    findFlag = false
                    break
                }
            }
            if (findFlag) {
                queue.add(MapPoint(curPoint.y, board[curPoint.y].lastIndex, curPoint.sum + 1))
            }
        } else {
            if (hash[rightStartPoint]!! > curPoint.sum) {
                hash[rightStartPoint] = curPoint.sum
                var findFlag = true
                for (x in curPoint.x - 1 downTo 0) {
                    if (board[curPoint.y][x] == 'D') {
                        queue.add(MapPoint(curPoint.y, x - 1, curPoint.sum + 1))
                        findFlag = false
                        break
                    }
                }
                if (findFlag) {
                    queue.add(MapPoint(curPoint.y, 0, curPoint.sum + 1))
                }
            }
        }

        val downStartPoint = Point("down", curPoint.y, curPoint.x)
        if (downStartPoint !in hash) {
            hash[downStartPoint] = curPoint.sum
            var findFlag = true
            for (y in curPoint.y + 1..board.lastIndex) {
                if (board[y][curPoint.x] == 'D') {
                    queue.add(MapPoint(y - 1, curPoint.x, curPoint.sum + 1))
                    findFlag = false
                    break
                }
            }
            if (findFlag) {
                queue.add(MapPoint(board.lastIndex, curPoint.x, curPoint.sum + 1))
            }
        } else {
            if (hash[downStartPoint]!! > curPoint.sum) {
                hash[downStartPoint] = curPoint.sum
                var findFlag = true
                for (y in curPoint.y + 1..board.lastIndex) {
                    if (board[y][curPoint.x] == 'D') {
                        queue.add(MapPoint(y - 1, curPoint.x, curPoint.sum + 1))
                        findFlag = false
                        break
                    }
                }
                if (findFlag) {
                    queue.add(MapPoint(board.lastIndex, curPoint.x, curPoint.sum + 1))
                }
            }
        }

        val upStartPoint = Point("up", curPoint.y, curPoint.x)
        if (upStartPoint !in hash) {
            hash[upStartPoint] = curPoint.sum
            var findFlag = true
            for (y in curPoint.y - 1 downTo 0) {
                if (board[y][curPoint.x] == 'D') {
                    queue.add(MapPoint(y + 1, curPoint.x, curPoint.sum + 1))
                    findFlag = false
                    break
                }
            }
            if (findFlag) {
                queue.add(MapPoint(0, curPoint.x, curPoint.sum + 1))
            }
        } else {
            if (hash[downStartPoint]!! > curPoint.sum) {
                hash[upStartPoint] = curPoint.sum
                var findFlag = true
                for (y in curPoint.y - 1 downTo 0) {
                    if (board[y][curPoint.x] == 'D') {
                        queue.add(MapPoint(y + 1, curPoint.x, curPoint.sum + 1))
                        findFlag = false
                        break
                    }
                }
                if (findFlag) {
                    queue.add(MapPoint(0, curPoint.x, curPoint.sum + 1))
                }
            }
        }


    }
}

class Solution {
    fun solution(board: Array<String>): Int {
        bfs(board)
        if (answer == Int.MAX_VALUE) {
            answer = -1
        }
        return answer
    }
}