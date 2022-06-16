def solution(bridge_length, weight, truck_weights):
    answer = 0
    
    finish_truck=[]
    now_sum=0
    driving_truck=[]
    all_truck_num=len(truck_weights) 
    truck_weights.reverse()
    
    
    #len(finish_truck) != all_truck_num
    
    while len(finish_truck) != all_truck_num :
     
        answer+=1
        if driving_truck:
            for i in driving_truck:
                i[1]+=1
            if driving_truck[0][1] > bridge_length:
                now_sum-=driving_truck[0][0]
                finish_truck.append(driving_truck[0][0])
                driving_truck.pop(0)
                
        if truck_weights :
            if now_sum + truck_weights[-1] <= weight :  
                start_truck=truck_weights.pop()
                now_sum+=start_truck
                driving_truck.append([start_truck,1])
            
        
            
    return answer