import sys
#sys.stdin=open("input.txt","rt")

#N,M = map(int,input().split())
N = int(input())
N_arr= list(map(int,input().split()))

res_arr=[]
res_num=[]

lf=0
rf=N-1

if N_arr[lf]<N_arr[rf]:
    res_arr.append('L')
    res_num.append(N_arr[lf])
    lf+=1
else:
    res_arr.append('R')
    res_num.append(N_arr[rf])
    rf-=1
check_lf=False
check_rf=False
while lf<=rf:
 
    if check_lf and check_rf:
        break

    if lf==rf :
        if N_arr[lf]>res_num[-1]:
            res_arr.append('L')      
        break
    else:
        if N_arr[lf]>N_arr[rf]:
            if N_arr[rf]>res_num[-1]:
                res_num.append(N_arr[rf])
                res_arr.append('R')
                rf-=1
                check_rf=False
            else:
                check_rf=True
                if N_arr[lf]>res_num[-1]:
                    res_num.append(N_arr[lf])
                    res_arr.append('L')
                    lf+=1
                    check_lf=False
                else:
                    check_lf=True

                
        else:
            if N_arr[lf]>res_num[-1]:
                res_num.append(N_arr[lf])
                res_arr.append('L')
                lf+=1
                check_lf=False
            else:
                if N_arr[rf]>res_num[-1]:
                    res_num.append(N_arr[rf])
                    res_arr.append('R')
                    rf-=1
                    check_rf=False
                else:
                    check_rf=True    
                check_lf=True
               
print(len(res_arr))
for i in res_arr:
    print(i,end = '')


