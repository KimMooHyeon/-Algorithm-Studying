class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var answer: Int = 0
        var bookTime = book_time.sortedWith(compareBy { it[0] })
        var startTime = book_time.sortedWith(compareBy { it[0] })[0][0]
        var lastTime = book_time.sortedWith(compareBy { it[1] })[book_time.size-1][1]
        val start = startTime.split(":")[0].toInt()*60 +startTime.split(":")[1].toInt()
        val end = lastTime.split(":")[0].toInt()*60 +lastTime.split(":")[1].toInt()
        var mapArray=Array(end+20){0}
  
        bookTime.forEach{ temp->
             for(i in temp[0].split(":")[0].toInt()*60+temp[0].split(":")[1].toInt() .. temp[1].split(":")[0].toInt()*60+temp[1].split(":")[1].toInt()+9){
                   mapArray[i]+=1
               }
        }

        return mapArray.maxOrNull()!!
    }
}