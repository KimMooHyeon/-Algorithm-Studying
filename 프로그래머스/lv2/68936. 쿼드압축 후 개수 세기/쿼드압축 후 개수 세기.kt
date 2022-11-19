class Solution {
    var hashMapCount = mutableMapOf(0 to 0, 1 to 0)
    fun solution(arr: Array<IntArray>): IntArray {

        var zeroCount = 0
        var oneCount = 0
        var arrSize = arr.size
        var answer: IntArray = intArrayOf()
        var checkList = Array(arrSize) { Array(arrSize) { true } }
        var tempList = mutableListOf<IntArray>()
        arr.forEach {
            tempList.add(it)
        }
       recursive(tempList)
        return intArrayOf(hashMapCount[0]!!,hashMapCount[1]!!)
    }

    fun recursive(arr: MutableList<IntArray>) {
        if (arr[0].size <= 1) {
            hashMapCount[arr[0][0]] = hashMapCount[arr[0][0]]!! + 1
        } else {
            if (checkAllNumSame(arr)) {
                hashMapCount[arr[0][0]] = hashMapCount[arr[0][0]]!! + 1
            } else {
                var tempN = splitArray(arr)
                tempN.forEach {
                    if(it.isNotEmpty()){
                          recursive(it)
                    }
                }
            }
        }
    }
    fun splitArray(arr: MutableList<IntArray>): MutableList<MutableList<IntArray>> {
        var halpSize = arr.size / 2
        var xOffset = mutableListOf<Int>(0, halpSize, 0, halpSize)
        var yOffset = mutableListOf<Int>(0, 0, halpSize, halpSize)
        var tempArray = mutableListOf<MutableList<IntArray>>()
        if (arr.size <= 1) {
            hashMapCount[arr[0][0]] = hashMapCount[arr[0][0]]!! + 1
            return tempArray
        }
        for (i in 0 until 4) {
            var tempbigList = mutableListOf<IntArray>()
            for (k in yOffset[i] until yOffset[i] + halpSize) {
                var tempList = mutableListOf<Int>()
                for (j in xOffset[i] until xOffset[i] + halpSize) {
                    tempList.add(arr[k][j])
                }
                tempbigList.add(tempList.toIntArray())
            }
            tempArray.add(tempbigList)
        }
        return tempArray
    }
    
    fun checkAllNumSame(arr: MutableList<IntArray>): Boolean {
        var startNum = arr[0][0]
        for (i in 0 until arr.size) {
            for (j in 0 until arr.size) {
                if (startNum != arr[i][j]) {
                    return false
                }
            }
        }
        return true
    }
}