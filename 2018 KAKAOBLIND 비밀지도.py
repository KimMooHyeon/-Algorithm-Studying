def solution(n, arr1, arr2):
    answer = []
    bin_arr1=[]
    bin_arr2=[]
    for i in range(0,n):
        a=bin(arr1[i])
        b=bin(arr2[i])
        bin_arr1.append(a[2:].zfill(n))
        bin_arr2.append(b[2:].zfill(n))
        
    for i in range(0,n):
        answer_arr=""
        for j in range(0,n):
            if bin_arr1[i][j] == '1' or bin_arr2[i][j] == '1':
                answer_arr+='#'
            else:
                answer_arr+=" "
        answer.append(answer_arr)
            
    
    return answer