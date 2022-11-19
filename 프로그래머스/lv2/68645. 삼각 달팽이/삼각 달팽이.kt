class Solution {
    lateinit var mapList: Array<Array<Boolean>>
    lateinit var answerList: Array<Array<Int>>
    lateinit var answer: IntArray
    var new_x=0
    var new_y=0
    var number = 1
    var chk = 0
    fun solution(n: Int): IntArray {
        answer = IntArray((n * (n + 1)) / 2) { 0 }
        mapList = Array(n + 1) { Array(n + 1) { false } }
        answerList = Array(n + 1) { Array(n + 1) { 0 } }

        for (i in 0 until n) {
            for (j in 0..i) {
                mapList[i][j] = true
            }
        }
        dfs(0, 0, n)
        checkMapValue(answerList)
       // checkMap(mapList)

        return answer
    }
    fun dfs(x: Int, y: Int,n:Int) {
      //  println("new_x = $new_x new_y= $new_y ")
       while(mapList[new_y][new_x]){
            dfsDown(new_x,new_y)
            
        }
      //  println("new_x = $new_x new_y= $new_y ")
    }

    fun dfsDown(x: Int, y: Int) {

        mapList[y][x] = false
        answerList[y][x] = number++
        if (mapList[y + 1][x]) {
            dfsDown(x, y + 1)
        } else {
            dfsRight(x + 1, y)
        }

    }

    fun dfsRight(x: Int, y: Int) {
        if(!mapList[y][x]){
            return
        }

        mapList[y][x] = false
        answerList[y][x] = number++
        if (mapList[y][x + 1]) {
            dfsRight(x + 1, y)
        } else {
            dfsLeftTop(x - 1, y - 1)
        }
    }

    fun dfsLeftTop(x: Int, y: Int) {
        if(!mapList[y][x]){
            return
        }

        mapList[y][x] = false
        answerList[y][x] = number++
        if(y-1>=0){
            if (mapList[y - 1][x - 1] == false) {
               // dfsDown(x, y + 1, number + 1)
                mapList[y][x]=true
                answerList[y][x]=0
                number--
                new_x=x
                new_y=y
            } else {
                dfsLeftTop(x - 1, y - 1)
            }
        }else{
            new_x=x
            new_y=y
          //  dfsDown(x, y + 1, number + 1)
        }

    }

    fun checkMap(mapList: Array<Array<Boolean>>) {
        mapList.forEach {
            it.forEach { a ->
            //     print("$a ")
            }
             println()
        }
    }

    fun checkMapValue(mapList: Array<Array<Int>>) {
        mapList.forEach {
            it.forEach { a ->
                if (a != 0) {
                    answer[chk] = a
                    if (chk + 1 < answer.size) {
                        chk += 1
                    }
                }
                // print("$a ")
            }
             println()
        }
    }
}