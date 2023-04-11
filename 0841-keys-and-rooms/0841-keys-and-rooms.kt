import java.util.*

class Solution {
    fun bfs(rooms: List<List<Int>>,door:BooleanArray):Boolean{
        val queue = LinkedList<Int>()
        val roomSize = rooms.size
        var openDoor = 1
        door[0]=false
        queue.add(0)
        while(queue.isNotEmpty()){
            val curDoor = queue.poll()
            for(i in 0 until rooms[curDoor].size){
                if(door[rooms[curDoor][i]]){
                    queue.add(rooms[curDoor][i])
                    door[rooms[curDoor][i]]=false
                    openDoor+=1
                }
            }
        }
        if(openDoor==roomSize){
            return true
        }else{
            return false
        }
    }
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val door=BooleanArray(rooms.size){true}
       return bfs(rooms,door)
    }
}