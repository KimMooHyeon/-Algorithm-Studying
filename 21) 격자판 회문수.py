import sys
#sys.stdin=open("input.txt","rt")

def solFun(a_arr):
    for i in range(0,2):
        if a_arr[i] != a_arr[-1-i]:
            # 회문수가 아닐경우
            return False
            break
    else:
        # 회문수 일경우
        return True

#N = map(int,input().split())
#N= int(input())
N=7
N_arr=[list(map(int,input().split())) for _ in range(N)]
cnt=0
se_arr=[]
for i in range(7):
    for j in range(3):
        if solFun(N_arr[i][j:j+5]):
            cnt+=1
        se_arr.clear()
        for k in range(5):
            se_arr.append(N_arr[j+k][i])
        if solFun(se_arr):
            cnt+=1

print(cnt)


        