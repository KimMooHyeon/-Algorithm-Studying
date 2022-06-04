import sys
#sys.stdin=open("input.txt","rt")


N = int(input())
N_arr = list(map(int,input().split()))

pro_flag = False
plus_num=1
rol_sum = 0

for i in N_arr:
    if i == 0 : 
        plus_num=1
    else : 
        rol_sum+=plus_num
        plus_num+=1

print(rol_sum)