import java.io.BufferedReader
import java.io.InputStreamReader

data class Robot(var x: Int, var y: Int, var direction: String) {
    fun changeLDirection() {
        when (this.direction) {
            "W" -> {
                this.direction = "S"
            }
            "N" -> {
                this.direction = "W"
            }
            "E" -> {
                this.direction = "N"
            }
            "S" -> {
                this.direction = "E"
            }
        }
    }

    fun changeRDirection() {
        when (this.direction) {
            "W" -> {
                this.direction = "N"
            }
            "N" -> {
                this.direction = "E"
            }
            "E" -> {
                this.direction = "S"
            }
            "S" -> {
                this.direction = "W"
            }
        }
    }
}

lateinit var map: Array<Array<Robot?>>
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    // 가로 세로
    // 4,3
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    map = Array(b) { Array(a) { null } }
    // 로봇의 개수, 명령어 수
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val robotList = mutableListOf<Robot>()
    repeat(n) {
        //초기 로봇의 위치
        val (_x, _y, direction) = br.readLine().split(" ")
        val x = _x.toInt()
        val y = _y.toInt()
        val robot = Robot(x - 1, b - y, direction)

        robotList.add(robot)
        map[b - y][x - 1] = robot
    }

    var okFlag = true
    for (i in 0 until m) {
        if (okFlag.not()) break
        //명령어
        val (num, command, repeatNum) = br.readLine().split(" ")
        for (j in 0 until repeatNum.toInt()) {
            if (okFlag.not()) break
            //map[robotList[num.toInt()-1].y][robotList[num.toInt()-1].x]
            when (command) {
                "L" -> {
                    robotList[num.toInt() - 1].changeLDirection()
                }
                "R" -> {
                    robotList[num.toInt() - 1].changeRDirection()
                }
                "F" -> {
                    var xNum = robotList[num.toInt() - 1].x
                    var yNum = robotList[num.toInt() - 1].y
                    when (robotList[num.toInt() - 1].direction) {
                        "W" -> {
                            xNum = robotList[num.toInt() - 1].x - 1
                        }
                        "N" -> {
                            yNum = robotList[num.toInt() - 1].y - 1
                        }
                        "E" -> {
                            xNum = robotList[num.toInt() - 1].x + 1
                        }
                        "S" -> {
                            yNum = robotList[num.toInt() - 1].y + 1
                        }
                    }
                    if (xNum < 0 || xNum >= a || yNum < 0 || yNum >= b) {
                        println("Robot $num crashes into the wall")
                        okFlag = false
                    } else {
                        if (map[yNum][xNum] != null) {
                            println("Robot $num crashes into robot ${robotList.indexOf(map[yNum][xNum]) + 1}")
                            okFlag = false
                        } else {
                            map[robotList[num.toInt() - 1].y][robotList[num.toInt() - 1].x] = null
                            robotList[num.toInt() - 1].x = xNum
                            robotList[num.toInt() - 1].y = yNum
                            map[yNum][xNum] = robotList[num.toInt() - 1]
                        }
                    }
                }
                else -> {
                }
            }
        }
    }
    if (okFlag) {
        println("OK")
    }
    br.close()
}

