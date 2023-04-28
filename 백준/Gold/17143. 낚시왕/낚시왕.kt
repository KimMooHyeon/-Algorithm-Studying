import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

// s는 속력
// d 가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
// z는 크기
data class Shake(var r: Int, var c: Int, val s: Int, var d: Int, val z: Int)


fun getRPoint(num:Int,r:Int):Int{
    return num % ((r - 1) * 2)
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(r) { Array<Shake?>(c) { null } }
    val shakeList = mutableListOf<Shake>()
    repeat(m) {
        val (_r, _c, _s, _d, _z) = br.readLine().split(" ").map { it.toInt() }
        if (map[_r - 1][_c - 1] == null) {
            map[_r - 1][_c - 1] = Shake(_r - 1, _c - 1, _s, _d, _z)
            shakeList.add(map[_r - 1][_c - 1]!!)
        }
    }

    var answer = 0
    val removeHash = HashMap<Shake, Boolean>()
    for (i in 0 until c) {
        for (j in 0 until r) {
            // 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡기
            if (map[j][i] != null) {
                answer += map[j][i]!!.z
                // 상어 사라짐
                removeHash[map[j][i]!!] = true
                map[j][i] = null
                break
            }
        }
        val moveHashMap = HashMap<Shake, Boolean>()
        //상어 이동
        // s는 속력
        // d 가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
        shakeList.forEach { shake ->
            if (shake !in removeHash) {
                when (shake.d) {
                    1 -> {
                        var startR = shake.r
                        var flag = true
                        if (startR == 0) {
                            flag = false
                             shake.d = 2
                        }

                        repeat(getRPoint(shake.s,r)) {
                            if (flag) {
                                if (startR - 1 == 0) {
                                    startR = 0
                                    flag = false
                                    shake.d = 2
                                } else if (startR - 1 > 0) {
                                    startR -= 1
                                }
                            } else {
                                // 방향 전환
                                shake.d = 2
                                if (startR + 1 == r - 1) {
                                    flag = true
                                    shake.d = 1
                                    startR += 1
                                } else if (startR + 1 < r - 1) {
                                    startR += 1
                                }
                            }
                        }

                        if (shake.r != startR && map[shake.r][shake.c] == shake) {
                            map[shake.r][shake.c] = null
                        }
                        shake.r = startR
                        if (map[startR][shake.c] == null) {
                            map[startR][shake.c] = shake
                            moveHashMap[shake] = true
                        } else {
                            if (map[startR][shake.c] in moveHashMap) {
                                if (map[startR][shake.c]!!.z < shake.z) {
                                    removeHash[map[startR][shake.c]!!] = true
                                    map[startR][shake.c] = shake
                                    moveHashMap[shake] = true
                                } else {
                                    // 오히려 먹힘
                                    removeHash[shake] = true
                                    moveHashMap[shake] = true
                                }
                            } else {
                                map[startR][shake.c] = shake
                                moveHashMap[shake] = true
                            }
                        }
                    }
                    2 -> {
                        // 아래
                        var startR = shake.r
                        var flag = false
                        if (startR == r - 1) {
                            flag = true
                            shake.d = 1
                        }
                        repeat(getRPoint(shake.s,r)) {
                            if (flag) {
                                if (startR - 1 == 0) {
                                    startR = 0
                                    flag = false
                                    shake.d = 2
                                } else if (startR - 1 > 0) {
                                    startR -= 1
                                }
                            } else {
                                // 방향 전환
                                if (startR + 1 == r - 1) {
                                    flag = true
                                    shake.d = 1
                                    startR += 1
                                } else if (startR + 1 < r - 1) {
                                    startR += 1
                                }
                            }
                        }

                        if (map[shake.r][shake.c] == shake) {
                            map[shake.r][shake.c] = null
                        }
                        shake.r = startR
                        if (shake.r != startR && map[startR][shake.c] == null) {
                            map[startR][shake.c] = shake
                            moveHashMap[shake] = true
                        } else {
                            if (map[startR][shake.c] in moveHashMap) {
                                if (map[startR][shake.c]!!.z < shake.z) {
                                    removeHash[map[startR][shake.c]!!] = true
                                    map[startR][shake.c] = shake
                                    moveHashMap[shake] = true
                                } else {
                                    // 오히려 먹힘
                                    removeHash[shake] = true
                                    moveHashMap[shake] = true
                                }
                            } else {
                                map[startR][shake.c] = shake
                                moveHashMap[shake] = true
                            }

                        }
                    }
                    3 -> {
                        // 오른쪽
                        var startC = shake.c
                        var flag = false
                        if (startC == c - 1) {
                            flag = true
                            shake.d = 4
                        }
                        repeat(getRPoint(shake.s,c)) {
                            if (flag) {
                                if (startC - 1 == 0) {
                                    startC = 0
                                    flag = false
                                    shake.d = 3
                                } else if (startC - 1 > 0) {
                                    startC -= 1
                                }
                            } else {
                                // 방향 전환
                                if (startC + 1 == c - 1) {
                                    flag = true
                                    shake.d = 4
                                    startC += 1
                                } else if (startC + 1 < c - 1) {
                                    startC += 1
                                }
                            }
                        }
                        if (shake.c != startC && map[shake.r][shake.c] == shake) {
                            map[shake.r][shake.c] = null
                        }
                        shake.c = startC
                        if (map[shake.r][startC] == null) {
                            map[shake.r][startC] = shake
                            moveHashMap[shake] = true
                        } else {
                            if (map[shake.r][startC] in moveHashMap) {
                                if (map[shake.r][startC]!!.z < shake.z) {
                                    removeHash[map[shake.r][startC]!!] = true
                                    map[shake.r][startC] = shake
                                    moveHashMap[shake] = true
                                } else {
                                    // 오히려 먹힘
                                    removeHash[shake] = true
                                    moveHashMap[shake] = true
                                }
                            } else {
                                map[shake.r][startC] = shake
                                moveHashMap[shake] = true
                            }
                        }
                    }
                    4 -> {
                        // 왼쪽
                        var startC = shake.c
                        var flag = true
                        if (startC == 0) {
                            flag = false
                            shake.d = 3
                        }
                        repeat(getRPoint(shake.s,c)) {
                            if (flag) {
                                if (startC - 1 == 0) {
                                    startC = 0
                                    flag = false
                                    shake.d = 3
                                } else if (startC - 1 > 0) {
                                    startC -= 1
                                }
                            } else {
                                // 방향 전환
                                if (startC + 1 == c - 1) {
                                    flag = true
                                    shake.d = 4
                                    startC += 1
                                } else if (startC + 1 < c - 1) {
                                    startC += 1
                                }
                            }
                        }
                        //println("${shake.r} ${shake.c} map[shake.r][shake.c] = ${map[shake.r][shake.c]}")
                        if (shake.c != startC && map[shake.r][shake.c] == shake) {
                            map[shake.r][shake.c] = null
                        }
                        shake.c = startC
                        if (map[shake.r][startC] == null) {
                            map[shake.r][startC] = shake
                            moveHashMap[shake] = true
                        } else {
                            if (map[shake.r][startC] in moveHashMap) {
                                if (map[shake.r][startC]!!.z < shake.z) {
                                    removeHash[map[shake.r][startC]!!] = true
                                    map[shake.r][startC] = shake
                                    moveHashMap[shake] = true
                                } else {
                                    // 오히려 먹힘
                                    removeHash[shake] = true
                                    moveHashMap[shake] = true
                                }
                            } else {
                                map[shake.r][startC] = shake
                                moveHashMap[shake] = true
                            }
                        }
                    }
                }
            }

        }
    }

    println(answer)
}

