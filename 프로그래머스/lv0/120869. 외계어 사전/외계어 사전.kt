class Solution {
    fun solution(spell: Array<String>, dic: Array<String>) =
        if (dic.filter { it.length == spell.size }.filter {
                it.toList().sorted().joinToString("") == spell.sorted().joinToString("")
            }.size == 1) 1 else 2
}