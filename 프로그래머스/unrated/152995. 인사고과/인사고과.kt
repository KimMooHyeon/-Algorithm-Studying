import java.util.*

data class Person(val index: Int, val companyScore: Int, val coworkerScore: Int, val sumScore: Int)
class Solution {
    fun solution(scores: Array<IntArray>): Int {
        var answer: Int = -1
        var win = 1
        var maxScore = -1
        var duplicateNum = 0
        var flag = true
        val personList = PriorityQueue<Person>(compareBy { it.companyScore })
        val scoreList = PriorityQueue<Person>(compareBy { -it.sumScore })
        lateinit var wonho :Person
        lateinit var newPerson :Person
        scores.forEachIndexed { i, v ->
            if (i == 0){
                wonho= Person(i, v[0], v[1], v[0] + v[1])
                personList.add(wonho)
            }else{
                if (wonho.sumScore<v[0] + v[1]){
                    personList.add(Person(i, v[0], v[1], v[0] + v[1]))
                }
            }
        }
        //personList.sortWith(compareBy({it.companyScore}))
        lateinit var tempPerson :Person
        while (personList.isNotEmpty()) {
            tempPerson = personList.poll()
            flag = true
            if (personList.isEmpty()) {
                scoreList.add(tempPerson)
                break
            } else {
                for (it in personList) {
                    if ((tempPerson.companyScore < it.companyScore) &&
                        (tempPerson.coworkerScore < it.coworkerScore)
                    ) {
                        flag = false
                        break
                    }
                }
                if (flag) {
                    scoreList.add(tempPerson)
                }
            }
        }
        lateinit var tempScore : Person
        while (scoreList.isNotEmpty()) {
            tempScore = scoreList.poll()
            if (maxScore == -1) {
                maxScore = tempScore.sumScore
                duplicateNum += 1
                if (tempScore.index == 0) {
                    answer = win
                    return answer
                }
            } else {
                if (maxScore == tempScore.sumScore) {
                    duplicateNum += 1
                    if (tempScore.index == 0) {
                        answer = win
                        return answer
                    }
                } else {
                    maxScore = tempScore.sumScore
                    win += duplicateNum
                    duplicateNum = 1
                    if (tempScore.index == 0) {
                        answer = win
                        return answer
                    }
                }
            }
        }
        return answer
    }
}