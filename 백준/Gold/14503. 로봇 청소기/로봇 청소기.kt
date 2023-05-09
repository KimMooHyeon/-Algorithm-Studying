import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

data class Robot(var y: Int, var x: Int, var direction: Int) {
    //
    //$d$가
    //$0$인 경우 북쪽,
    //$1$인 경우 동쪽,
    //$2$인 경우 남쪽,
    //$3$인 경우 서쪽을 바라보고 있는 것이다.
    fun change() {
        when (direction) {
            0 -> {
                this.direction = 3
            }
            1 -> {
                this.direction = 0
            }
            2 -> {
                this.direction = 1
            }
            3 -> {
                this.direction = 2
            }
        }
    }
}

val yOffset = listOf(1, -1, 0, 0)
val xOffset = listOf(0, 0, 1, -1)
var answer = 0
val robot = Robot(0, 0, 0)


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val _robot = br.readLine().split(" ").map { it.toInt() }
    robot.y = _robot[0]
    robot.x = _robot[1]
    robot.direction = _robot[2]
    val map = Array(n) { IntArray(m) }
    val cleanMap = Array(n) { BooleanArray(m) { true } }
    repeat(n){
        val temp = br.readLine().split(" ").map { it.toInt() }
        map[it]=temp.toIntArray()
    }
    while (true) {
        
        if (cleanMap[robot.y][robot.x]) {
            answer += 1
            cleanMap[robot.y][robot.x] = false
        }
        var cleanFlag = true
        for (i in 0..3) {
            val nextY = robot.y + yOffset[i]
            val nextX = robot.x + xOffset[i]
            if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                if (cleanMap[nextY][nextX] && map[nextY][nextX] != 1) {

                    cleanFlag = false
                    break
                }
            }
        }
        if (cleanFlag) {
            //빈칸이없는경우
            when (robot.direction) {
                0 -> {
                    // 북쪽
                    val nextY = robot.y + 1
                    val nextX = robot.x
                    if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                        if (map[nextY][nextX] == 1){
                            break
                        }
                        robot.y = robot.y + 1
                        continue
                    } else {
                        break
                    }
                }
                1 -> {
                    // 동쪽
                    val nextY = robot.y
                    val nextX = robot.x - 1
                    if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                        if (map[nextY][nextX] == 1){
                            break
                        }
                        robot.x = robot.x - 1
                        continue
                    } else {
                        break
                    }
                }
                2 -> {
                    // 남쪽
                    val nextY = robot.y - 1
                    val nextX = robot.x
                    if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                        if (map[nextY][nextX] == 1){
                            break
                        }
                        robot.y = robot.y - 1
                        continue
                    } else {
                        break
                    }
                }
                3 -> {
                    // 서쪽
                    val nextY = robot.y
                    val nextX = robot.x + 1
                    if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                        if (map[nextY][nextX] == 1){
                            break
                        }
                        robot.x = robot.x + 1
                        continue
                    } else {
                        break
                    }
                }
            }
        } else {
            // 빈칸이 있는경우
            robot.change()
            when (robot.direction) {
                0 -> {
                    // 북쪽
                    val nextY = robot.y - 1
                    val nextX = robot.x
                    if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                        if (cleanMap[nextY][nextX] && map[nextY][nextX] != 1) {
                            robot.y = robot.y - 1
                            continue
                        }

                    }
                }
                1 -> {
                    // 동쪽
                    val nextY = robot.y
                    val nextX = robot.x + 1
                    if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                        if (cleanMap[nextY][nextX] && map[nextY][nextX] != 1)
                            robot.x = robot.x + 1
                        continue
                    }
                }
                2 -> {
                    // 남쪽
                    val nextY = robot.y + 1
                    val nextX = robot.x
                    if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                        if (cleanMap[nextY][nextX] && map[nextY][nextX] != 1)
                            robot.y = robot.y + 1
                        continue
                    }
                }
                3 -> {
                    // 서쪽
                    val nextY = robot.y
                    val nextX = robot.x - 1
                    if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                        if (cleanMap[nextY][nextX] && map[nextY][nextX] != 1)
                            robot.x = robot.x - 1
                        continue
                    }
                }
            }
        }
    }
    println(answer)

    br.close()
}
