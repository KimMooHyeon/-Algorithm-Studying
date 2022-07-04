import sys
sys.stdin=open("input.txt","rt")

N= int(input())
N_arr={}
for i in range(N):
    tmp = input()
    tmp = tmp[0]
    N_arr[tmp]=N_arr.get(tmp,0)+1

res=""

for key,value in N_arr.items():
    if value >= 5 :
        res+=key

if len(res) == 0 :
    print('PREDAJA')

else:
    res=list(res)
    res.sort()
    print("".join(res))