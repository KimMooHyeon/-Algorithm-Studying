lateinit var personWinList: Array<MutableList<Int>>
lateinit var personLoseList: Array<MutableSet<Int>>
lateinit var booleanList: BooleanArray

class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        personWinList = Array(n + 1) { mutableListOf<Int>() }
        personLoseList = Array(n + 1) { mutableSetOf<Int>() }
        booleanList = BooleanArray(n + 1) { true }

        results.forEach {
            personWinList[it[0]].add(it[1])
        }

        for (i in 1..n) {
            dfs(i, i)
        }

        for (i in 1..n) {
            if (personWinList[i].size + personLoseList[i].size == n - 1) {
                answer += 1
            }
        }
        return answer
    }

    fun dfs(firstIndex: Int, nowIndex: Int) {
        val listSize = personWinList[nowIndex].size
        if (listSize == 0) {
            return
        } else {
            if (booleanList[nowIndex]) {
                if (firstIndex == nowIndex) {
                    
                    personWinList[nowIndex].map { it }.forEach { person ->
                        if (person !in personWinList[firstIndex]){
                            personWinList[firstIndex].add(person)
                            personLoseList[person].add(firstIndex)
                            booleanList[nowIndex] = false
                            dfs(firstIndex, person)
                            booleanList[nowIndex] = true
                        }else{
                            personLoseList[person].add(firstIndex)
                            booleanList[nowIndex] = false
                            dfs(firstIndex, person)
                            booleanList[nowIndex] = true
                        }
                    }
                } else {
                    personWinList[nowIndex].forEach { person ->
                        if (person !in personWinList[firstIndex]){
                            personWinList[firstIndex].add(person)
                            personLoseList[person].add(firstIndex)
                            booleanList[nowIndex] = false
                            dfs(firstIndex, person)
                            booleanList[nowIndex] = true
                        }
                    }
                }
            }
        }
    }
}