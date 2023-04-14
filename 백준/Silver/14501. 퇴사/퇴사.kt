import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

data class Job(val time: Int, val pay: Int)

var answer = 0
fun sol(jobCost: Array<Job?>, nowDay: Int, endDay: Int, remainDay: Int, isJobing: Boolean, ingJobCost: Int, sum: Int) {
    if (nowDay >= endDay) {
        if (isJobing) {
            if (remainDay == 0) {
                if (sum+ingJobCost > answer) {
                    answer = sum+ingJobCost
                }
            }
        }
        if (sum > answer) {
            answer = sum
        }
        return
    }
    if (sum > answer) {
        answer = sum
    }
    // 시간초과 최적화
    if (remainDay > (endDay - nowDay)) {
        if (sum > answer) {
            answer = sum
        }
        return
    }
    //만약 현재 일이 진행중이라면 아무것도 못함
    if (isJobing) {
        //만약 job 진행중인데 끝났으면
        if (remainDay == 0) {
            //오늘일 선택
            if (jobCost[nowDay]!!.time == 1) {
                //바로 일처리
                sol(jobCost, nowDay + 1, endDay, -1, false, -1, sum + jobCost[nowDay]!!.pay + ingJobCost)
            } else {
                sol(
                    jobCost,
                    nowDay + 1,
                    endDay,
                    jobCost[nowDay]!!.time - 1,
                    true,
                    jobCost[nowDay]!!.pay,
                    sum + ingJobCost
                )
            }
            //오늘일 선택 안함
            sol(jobCost, nowDay + 1, endDay, 0, false, -1, sum + ingJobCost)
        } else {
            //아직 일이 안끝남
            sol(jobCost, nowDay + 1, endDay, remainDay - 1, true, ingJobCost, sum)
        }
    } else {
        //현재 일이 진행중이 아님
        // 오늘 일 선택
        if (jobCost[nowDay]!!.time == 1) {
            //바로 일처리
            sol(jobCost, nowDay + 1, endDay, -1, false, -1, sum + jobCost[nowDay]!!.pay)
        } else {
            sol(jobCost, nowDay + 1, endDay, jobCost[nowDay]!!.time - 1, true, jobCost[nowDay]!!.pay, sum)
        }

        // 오늘 일 안함
        sol(jobCost, nowDay + 1, endDay, -1, false, 0, sum)

    }

}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val jobCost = Array<Job?>(n + 1) { null }
    repeat(n) {
        val (t, p) = br.readLine().split(" ").map { it.toInt() }
        jobCost[it + 1] = Job(t, p)
    }
    sol(jobCost, 1, n + 1, -1, false, 0, 0)
    println(answer)



    br.close()
    bw.close()
}