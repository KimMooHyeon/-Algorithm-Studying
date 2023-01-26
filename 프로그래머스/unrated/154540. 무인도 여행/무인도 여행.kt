class Solution {
    fun solution(maps: Array<String>): MutableList<Int> {
        var answer = mutableListOf<Int>()
        val map = Array(maps.size) { Array(maps[0].length) { 0 } }

        maps.forEachIndexed { i, v ->
            for (j in 0..v.length - 1) {
                if (v[j] == 'X') {
                    map[i][j] = 0
                } else {
                    map[i][j] = v[j].toString().toInt()
                }
            }
        }    
        var temp =0
        val xPoint = arrayOf(0, 0, 1, -1)
        val yPoint = arrayOf(1, -1, 0, 0)
        fun dfs(i: Int, j: Int) {
            if(map[i][j]==0){
                return
            }else{     
                temp+=map[i][j]
                map[i][j] = 0
            }
            for (index in 0 .. 3) {
                val tempI = i + xPoint[index]
                val tempJ = j + yPoint[index]
                if (tempI >= 0 && tempJ >= 0 && tempI < maps.size && tempJ < maps[0].length) {
                    dfs(tempI,tempJ)

                }
            }
        }

        for (i in 0 until maps.size) {
            for (j in 0..maps[0].length - 1) {
                if (map[i][j] != 0) {
                    temp=0
                    dfs(i,j)
                    answer.add(temp)
                }
            }
        }
        if(answer.isEmpty()){
            answer.add(-1)
        }

        answer.sort()
        return answer
    }

}