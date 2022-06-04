import sys
#sys.stdin=open("input.txt","rt")

def check_arr(index,x):
    x=x.upper()
    for i in range(0,len(x)//2):
        if x[i] != x[-i-1]:
            print("#{} NO".format(index+1))
            break
    else :
        print("#{} YES".format(index+1))



N = int(input())
#N_arr = list(map(int,input().split()))

for i in range(N):
    x= input()
    check_arr(i,x)

