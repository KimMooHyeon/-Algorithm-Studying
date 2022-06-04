import sys
#sys.stdin=open("input.txt","rt")

def digit_sum(x):
    digitsum=0
    
    while True:
        if x<10:
            digitsum+=x
            break
        digitsum+=x%10
        x=x//10
    return digitsum
        

N = map(int,input().split())

N_arr = list(map(int,input().split()))
res_arr=[]
sol_arr=[]

for i in N_arr:
    res_arr.append(digit_sum(i))
for j in N_arr:
    if digit_sum(j) == max(res_arr):
        print(j)
        break