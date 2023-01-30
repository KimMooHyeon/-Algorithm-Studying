import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

data class Person(var trueInfo: Boolean, val nameNumber: Int)

lateinit var checkUpdateParty: BooleanArray
// index는 party, 각 파티에 참석한 참가자들의 정보
lateinit var partyParticipantList: Array<MutableList<Person>>

// index는 참가자들의 번호, 각 참가자들이 참석한 파티의 번호 정보
lateinit var personPartyList: Array<MutableList<Int>>

// 최초에 주어지는 진실을 아는 사람의 정보
val startTruePersonList = mutableListOf<Int>()
var solveNum = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val truePerson = br.readLine().split(" ").map { it.toInt() }

    checkUpdateParty = BooleanArray(m + 1) { true }

    val truePersonList = Array(n + 1) { Person(false, it) }
    for (i in 1..truePerson[0]) {
        truePersonList[truePerson[i]].trueInfo = true
        startTruePersonList.add(truePerson[i])
    }
    partyParticipantList = Array(m + 1) { mutableListOf<Person>() }
    personPartyList = Array(n + 1) { mutableListOf() }
    for (i in 1..m) {
        val partyInfo = br.readLine().split(" ").map { it.toInt() }
        for (j in 1..partyInfo[0]) {
            personPartyList[partyInfo[j]].add(i)
        }
        partyParticipantList[i].addAll(partyInfo.subList(1, partyInfo[0] + 1).map { personNumber ->
            truePersonList[personNumber]
        })
    }

    for (i in startTruePersonList) {
        dfs(personPartyList[i])
    }

    for (i in 1 until partyParticipantList.size) {
        if (partyParticipantList[i].all { !it.trueInfo }){
            solveNum+=1
        }
    }
    bw.write("$solveNum")
    br.close()
    bw.close()
}

fun dfs(truePartyList: MutableList<Int>) {

    truePartyList.forEach { partyNumber ->
        if (checkUpdateParty[partyNumber]) {
            //진실인 사람들이 참여한 party에 사람 리스트
            checkUpdateParty[partyNumber] = false
            partyParticipantList[partyNumber].forEach {
                it.trueInfo = true
            }
            partyParticipantList[partyNumber].map { it.nameNumber }.forEach {
                dfs(personPartyList[it])
            }
        }
    }
}