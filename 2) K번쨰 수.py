import sys
#sys.stdin=open("input.txt","rt")

T = int(input())


for i in range(1,T+1):
    N,s,e,k = map(int,input().split())
    N_arr=list(list(map(int,input().split())))
    res_arr= N_arr[s-1:e]
    res_arr.sort()

    res=0

    print("#{} {}".format(i, res_arr[k-1]))
