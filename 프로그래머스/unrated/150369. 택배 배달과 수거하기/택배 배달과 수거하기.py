def carryDeliverie(deliveries,i,cap,deliList):
    popnum=0
    for index in range(len(deliList)-1,-1,-1):
        if cap>0:
            if deliList[index][1]>0:
                if cap>=deliList[index][1]:
                    cap-=deliList[index][1]
                    deliveries[deliList[index][0]]=0
                    popnum+=1
                else:
                    deliveries[deliList[index][0]]-=cap
                    deliList[index][1]-=cap
                    cap=0
        else: 
            break
    for i in range(0,popnum):
        deliList.pop()
        
            
def carrypickups(pickups,i,cap,pickList):
    popnum=0
    for index in range(len(pickList)-1,-1,-1):
        if cap>0:
            if pickList[index][1]>0:
                if cap>=pickList[index][1]:
                    cap-=pickList[index][1]
                    pickups[pickList[index][0]]=0
                    popnum+=1
                else:
                    pickups[pickList[index][0]]-=cap
                    pickList[index][1]-=cap
                    cap=0
        else: 
            break
    for i in range(0,popnum):
        pickList.pop()
            
    

def solution(cap, n, deliveries, pickups):
    answer = 0
    deliList = []
    pickList = [] 
    for i,v in enumerate(deliveries):
        if v != 0 :
            deliList.append([i,v])
            
    for i,v in enumerate(pickups):
        if v != 0 :
            pickList.append([i,v])
            
    for i in range(n-1,-1,-1):
        while deliveries[i]>0 :
            carryDeliverie(deliveries,i,cap,deliList)
            carrypickups(pickups,i,cap,pickList)
            answer += (i+1)*2
        while pickups[i]>0 :
            carryDeliverie(deliveries,i,cap,deliList)
            carrypickups(pickups,i,cap,pickList)
            answer+= (i+1)*2
            
    return answer