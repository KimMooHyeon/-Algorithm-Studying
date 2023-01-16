data class Box(val boxNumber: Int, val cardNumber: Int, var isOpen: Boolean)
class Solution {
    var answer: Int = 0
    var boxList = mutableListOf<Box>(Box(0, 0, true))
    var tempList = mutableListOf<Int>()
    fun solution(cards: IntArray): Int {
        cards.forEachIndexed { i, v ->
            boxList.add(Box(i + 1, v, false))
        }
        for (i in 1 until cards.size) {
            dfs(i, 0, mutableListOf<Int>(), mutableListOf<Int>())
        }
        return answer
    }

    fun dfs(startIndex: Int, groupNumber: Int, firstSelect: MutableList<Int>, secondSelect: MutableList<Int>) {
       // println("$firstSelect $secondSelect $answer")
        if (boxList[startIndex].isOpen == true) {
            if (groupNumber == 0) {
                boxList.filter { it.isOpen == false }.forEach{ box ->
                    dfs(box.cardNumber, groupNumber + 1, firstSelect, secondSelect)
                }
            } else {
                val tempNum = firstSelect.size * secondSelect.size
                if (answer < tempNum) {
                    answer = tempNum
                }
                secondSelect.remove(boxList[startIndex].cardNumber)
                return
            }
        } else {
            if (groupNumber == 0) {
                boxList[startIndex].isOpen = true
                firstSelect.add(boxList[startIndex].cardNumber)
                dfs(boxList[startIndex].cardNumber, groupNumber, firstSelect, secondSelect)
                boxList[startIndex].isOpen = false
                firstSelect.remove(boxList[startIndex].cardNumber)
            } else {
                boxList[startIndex].isOpen = true
                secondSelect.add(boxList[startIndex].cardNumber)
                dfs(boxList[startIndex].cardNumber, groupNumber, firstSelect, secondSelect)
                boxList[startIndex].isOpen = false
                secondSelect.remove(boxList[startIndex].cardNumber)
            }
        }
    }
}