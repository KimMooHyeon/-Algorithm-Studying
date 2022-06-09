import sys
#sys.stdin=open("input.txt","rt")

#N = map(int,input().split())
#N= int(input())
N=9
N_arr=[list(map(int,input().split())) for _ in range(N)]
res_cnt=[]
check_flag=False
res_flag=True
for i in N_arr:
    res_cnt.clear()
    for j in i :
        if j not in res_cnt:
            res_cnt.append(j)
        else:
            check_flag=True
            break
    if check_flag:
        res_flag=False
        break
else:
    res_flag=True
check_flag=False

for i in range(0,9):
    res_cnt.clear()
    for j in range(0,9):
        if N_arr[j][i] not in res_cnt:
            res_cnt.append(N_arr[j][i])
        else : 
            check_flag=True
            break
    if check_flag:
        res_flag=False
        break
else:
    res_flag=True

check_flag=False
i_arr=[0,1,2,0,1,2,0,1,2]
j_arr=[0,0,0,1,1,1,2,2,2]
maini_arr=[0,3,6,0,3,6,0,3,6]
mainj_arr=[0,0,0,3,3,3,6,6,6]

for i in range(0,9):
    res_cnt.clear()
    for j in range(0,9):

        if N_arr[maini_arr[i]+i_arr[j]][mainj_arr[i]+j_arr[j]] not in res_cnt:
            res_cnt.append(N_arr[maini_arr[i]+i_arr[j]][mainj_arr[i]+j_arr[j]])
        else : 

            check_flag=True
      
            break
    if check_flag:
        res_flag=False
        
        break
else:
    res_flag=True

if res_flag:
    print("YES")
else:
    print("NO")
  
