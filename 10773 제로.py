import sys
#sys.stdin=open("input.txt", "r")


N =int(input())

#N_arr= list(map(int,input().split()))
N_arr=[]
cnt=0
for i in range(N):
    tmp=int(input())
    if tmp == 0 :
        if N_arr :
            N_arr.pop()
    else:
        N_arr.append(tmp)
print(sum(N_arr))