def check_fee(fees,out_time,in_time) :
    otime=0
    itime=0
    user_fee=0
    
    o_hour=out_time[0:2]
    o_min= out_time[3:5]
    
    otime=int(o_hour)*60+int(o_min)
    
    i_hour=in_time[0:2]
    i_min= in_time[3:5]
    
    itime=int(i_hour)*60+int(i_min)
    
    user_time = otime-itime
    
    if user_time<=fees[0]:
        return fees[1]
    else:
        user_fee+=fees[1]
        user_time-=fees[0]
        
        if user_time%fees[2]==0:
            user_fee+= (user_time//fees[2]) * fees[3]
        else:
            user_fee+= (user_time//fees[2]+1) * fees[3]
            
    return user_fee

def user_fee2(fees,user_time) :
    user_fee=0

    if user_time<=fees[0]:
        return fees[1]
    else:
        user_fee+=fees[1]
        user_time-=fees[0]
        
        if user_time%fees[2]==0:
            user_fee+= (user_time//fees[2]) * fees[3]
        else:
            user_fee+= (user_time//fees[2]+1) * fees[3]
            
    return user_fee

def user_time(out_time,in_time) :
    otime=0
    itime=0

    
    o_hour=out_time[0:2]
    o_min= out_time[3:5]
    
    otime=int(o_hour)*60+int(o_min)
    
    i_hour=in_time[0:2]
    i_min= in_time[3:5]
    
    itime=int(i_hour)*60+int(i_min)
    
    user_time = otime-itime
       
    return user_time    

def solution(fees, records):
    answer = []
    record_arr=[]
    check_stack=[]
    dic_fee={}
    
    for i in range(0,len(records)):
        time,num,act= map(str,records[i].split())
        record_arr.append([num,time,act])
        
    record_arr.sort()
    for j in range(0,len(record_arr)):
        #check_stack 값 있을경우
        if check_stack :
            
            #IN일경우
            if record_arr[j][2] =='IN':
                #IN일 경우 check_stack 마지막 값 비교해서 다르면  check_stack pop 하고 23:59 출차처리 진행 후 값 append
                if record_arr[j][0] != check_stack[-1]:
                    record_arr.append([check_stack[-1],'23:59','OUT'])
                    check_stack.pop()
                    check_stack.append(record_arr[j][0])
            elif record_arr[j][2] =='OUT':
                check_stack.pop()       
                
           #check_stack 비어있을경우
        else:
            #IN이니까 바로 들어온다.
            check_stack.append(record_arr[j][0])
    if check_stack:
        record_arr.append([check_stack[-1],'23:59','OUT'])
        
    record_arr.sort()   
    for k in range(0,len(record_arr),2):
        
        if record_arr[k][0] in dic_fee:
            dic_fee[record_arr[k][0]]+=user_time(record_arr[k+1][1],record_arr[k][1])
        else:
            dic_fee[record_arr[k][0]]=user_time(record_arr[k+1][1],record_arr[k][1])
        
    
    print(dic_fee)
    for i in dic_fee:
        print(user_fee2(fees,dic_fee[i]))
        answer.append(user_fee2(fees,dic_fee[i]))
    
    return answer