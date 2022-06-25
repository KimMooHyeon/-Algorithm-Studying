def check(arr):

    arr_dic = {}
    arr_dic[']'] ='['
    arr_dic[')'] ='('
    arr_dic['}'] ='{'
    

    len_num=len(arr)
    stack=[]
    cnt=0
    while len_num != cnt :

        if stack:
            
            if (arr[cnt] == ']' or arr[cnt] == '}' or arr[cnt] == ')' ) and (stack[-1] == arr_dic[arr[cnt]]):
                stack.pop()      
            else:
                stack.append(arr[cnt])
                
        else:
            stack.append(arr[cnt])
        cnt+=1
    if stack :
        return False
    else :

        return True

def solution(s):
    answer = 0
    s=list(s)
    for i in range(len(s)):
      
        tmp=s.pop(0)
        s.append(tmp)
        if check("".join(s)):     
       
            answer+=1

    return answer