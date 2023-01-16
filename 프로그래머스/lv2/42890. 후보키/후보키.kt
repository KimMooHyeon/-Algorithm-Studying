import java.util.*

class Solution {
    var ckList = LinkedList<MutableList<Int>>()
    lateinit var rel : Array<Array<String>>
    var answer = 0

    fun solution(relation: Array<Array<String>>): Int {
        rel = relation
        for(i in 1 .. relation[0].size){
            dfs(0,i,relation[0].size,mutableListOf<Int>())
        }
    
        while(ckList.isNotEmpty()){
            checkRelation(ckList.pop())
        }

        return answer
    }
    private fun checkRelation(selectList:MutableList<Int>){

        val resultList = mutableListOf<MutableList<String>>()
        rel.forEach{ it ->
            val temp = mutableListOf<String>()
            selectList.forEach{ sel->
                temp.add(it[sel])
            }
            resultList.add(temp)
        }
        if(resultList == resultList.distinct()) {
            answer+=1
            val tempList=LinkedList<MutableList<Int>>()
            selectList.forEach{ num->
                ckList.filter { num !in it}.forEach{
                    tempList.add(it)
                }
            }
            ckList=tempList
            //println("[selectList=${selectList}] 남은 리스트 $ckList")
        }
    }
    private fun dfs(start:Int, size:Int, maxSize:Int, selectList:MutableList<Int>){
        if(size==selectList.size){
            val temp = mutableListOf<Int>()
            temp.addAll(selectList)
            ckList.add(temp)
            return
        }else if(start>=maxSize){
            return
        }else{
            selectList.add(start)
            dfs(start+1,size,maxSize,selectList)
            selectList.remove(start)
            dfs(start+1,size,maxSize,selectList)
        }
    }
}