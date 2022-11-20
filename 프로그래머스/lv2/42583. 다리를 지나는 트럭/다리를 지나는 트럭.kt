import java.util.*

data class Truck(
    val truck_weight : Int ,
    var time :Int
)

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        var onBridgeWeight=0
        val truckNumber =truck_weights.size
        var onBridgeQueue: Queue<Truck> = LinkedList()
        val finishQueue: Queue<Truck> = LinkedList()
        val waitQueue: Queue<Truck> = LinkedList<Truck>().apply{
            truck_weights.forEach{ weight->
                add(Truck(weight,0))
            }
        }
        while(finishQueue.size!=truckNumber){
            answer+=1
        
            waitQueue.peek()?.let {
                if (onBridgeWeight+it.truck_weight<=weight){
                    onBridgeWeight+=it.truck_weight
                    onBridgeQueue.add(waitQueue.poll())
                }
            }
            onBridgeQueue.forEach { 
                it.time+=1
            }
             onBridgeQueue.peek()?.let {
                if (it.time>bridge_length){
                    onBridgeWeight-=it.truck_weight
                    finishQueue.add(onBridgeQueue.poll())
                 waitQueue.peek()?.let {
                if (onBridgeWeight+it.truck_weight<=weight){
                    onBridgeWeight+=it.truck_weight
                    val newTruck=waitQueue.poll()
                    onBridgeQueue.add(Truck(newTruck.truck_weight,1))
                }
            }
                }
            }
           
        }
        return answer
    }
}