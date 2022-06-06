import sys
import math
#sys.stdin=open("input.txt","rt")



N = input()
#N_arr = list(map(int,input().split()))
N_num=""
for i in N:
    if '0'<=i<='9':
        N_num+=i
cnt_num=0
N_num2=""
check_flag=False


for j in N_num :
    if check_flag:
        N_num2+=j
    else :
        if j=='0' :
            pass
        else:
            check_flag=True
            N_num2+=j


exit_num=int(N_num2)

for i in range(1,int(math.sqrt(exit_num))+1):

    if int(N_num2)%i ==0 :
        cnt_num+=2

    if i*i == int(N_num2):
        cnt_num-=1


print(N_num2)    
print(cnt_num)
   
