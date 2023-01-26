data class Person(val id: String, var flag: Boolean = true)

fun checkNum(size: Int, num: Int, list: MutableList<Person>): MutableList<List<Person>> {
    val boolean = BooleanArray(size) { true }
    val returnList = mutableListOf<List<Person>>()

    fun dfs(index: Int, selectedList: MutableList<Person>, num: Int, size: Int) {
        if (selectedList.size == num) {
            returnList.add(selectedList.map { it })
            return
        }
        if (index >= size) {
            return
        } else {
            if (boolean[index]) {
                boolean[index] = false
                selectedList.add(list[index])
                dfs(index + 1, selectedList, num, size)
                boolean[index] = true
                selectedList.remove(list[index])
                dfs(index + 1, selectedList, num, size)
            }
        }
    }
    dfs(0, mutableListOf<Person>(), num, size)
    return returnList
}

class Solution {
    private val hasDulple = HashMap<String, Int>()
    private val hs = HashMap<String, Int>()
    private val banIdList = HashMap<String, MutableList<Person>>()
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        var answer = 0
        val userList = mutableListOf<Person>()
        user_id.forEach {
            userList.add(Person(it))
        }
        banned_id.forEachIndexed { _, ban ->
            banIdList[ban] = mutableListOf<Person>()
            if (hs.containsKey(ban)) {
                hs[ban] = hs[ban]!! + 1
            } else {
                hs[ban] = 1
            }

            var temp = userList.filter { it.id.length == ban.length }
            for (i in ban.indices) {
                if (temp.isEmpty()) {
                    break
                } else {
                    temp = temp.filter { ban[i] == '*' || it.id[i] == ban[i] }
                }
            }
            temp.forEach {

                banIdList[ban]!!.add(it)
                if (hasDulple.containsKey(it.id)) {
                    hasDulple[it.id] = hasDulple[it.id]!! + 1
                } else {
                    hasDulple[it.id] = 0
                }
            }
        }
        val banIdListSize = banIdList.size
        val banIdMapList = Array(banIdListSize) { mutableListOf<List<Person>>() }
        val booleanMaxMy = BooleanArray(banIdListSize) { true }
        var mapIndex = 0

        banIdList.forEach { it ->
            banIdMapList[mapIndex] = checkNum(it.value.size, hs[it.key]!!, it.value)
            mapIndex += 1
        }

        val personSetList = mutableSetOf<List<Person>>()
        val personSetList2 = mutableSetOf<Set<Person>>()

        fun banDfs2(selectedList: MutableSet<Person>, depth: Int) {
       
            if (depth >= banIdListSize) {
                  if(banned_id.size == selectedList.size){
                //      println(selectedList)
                      personSetList2.add(selectedList.map { it }.toSet())
                }    
                return
            }
            banIdMapList[depth].forEach { people ->
                val temp = selectedList.map { it }.toMutableSet()
                temp.addAll(people)
                banDfs2(temp, depth + 1)
            }
        }

        fun banDfs(bigIndex: Int, startIndex: Int, trueCount: Int, selectedList: MutableSet<Person>) {

            if (trueCount >= banIdListSize) {
                personSetList.add(selectedList.map { it })
                return
            }
            if (bigIndex >= banIdListSize) {
                return
            } else {
                if (booleanMaxMy[bigIndex]) {
                    banIdMapList[startIndex].forEach { personList ->
                        if (personList.all { it.flag }) {
                            personList.forEach {
                                it.flag = false
                            }
                            selectedList.addAll(personList)
                            booleanMaxMy[bigIndex] = false
                            banDfs(bigIndex + 1, startIndex + 1, trueCount + 1, selectedList)
                            personList.forEach {
                                it.flag = true
                            }
                            selectedList.removeAll(personList.toSet())
                            booleanMaxMy[bigIndex] = true
                        }
                    }
                }
            }
        }
        banDfs2(mutableSetOf<Person>(), 0)
      
        return personSetList2.size
    }
}
