def solution(str1, str2):
    answer = 0
    str1=str1.upper()
    str2=str2.upper()
    str1_arr=""
    str2_arr=""
    str1_arr_list=[]
    str2_arr_list=[]
    
    for i in str1:
        str1_arr+=i

    for i in str2:
        str2_arr+=i

    for i in range(0,len(str1_arr)-1):
        
        if ('A'<=str1_arr[i]<='Z' ) and ('A'<=str1_arr[i+1]<='Z' ):
            str1_arr_list.append(str1_arr[i:i+2])
        
    for i in range(0,len(str2_arr)-1):
        
        if ('A'<=str2_arr[i]<='Z' ) and ('A'<=str2_arr[i+1]<='Z' ):
            str2_arr_list.append(str2_arr[i:i+2])
    # str1_arr_list
    # str2_arr_list
    
    str1_copy=str1_arr_list.copy()
    str2_copy=str2_arr_list.copy()
    intersection=[]
    plus_arr=[]
    for i in str1_arr_list:
        if i in str2_copy:
            intersection.append(i)
            str2_copy.remove(i)
            
    plus_arr= str1_arr_list+str2_copy
        
        
   # intersection = list((str1_arr_list) & (str2_arr_list))
   # plus_arr = list((str1_arr_list) | (str2_arr_list))
    
    print(str1_arr_list,str2_arr_list)      
    print(intersection,plus_arr)
    if len(intersection) == len(plus_arr):
        return 65536
    else: 
        return int((len(intersection)/len(plus_arr))*65536)