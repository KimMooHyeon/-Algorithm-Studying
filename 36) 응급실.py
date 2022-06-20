import sys
from collections import deque
#sys.stdin=open("input.txt","rt")

answer=0

# N명의 환자가 대기목록에있다.
# M번째 환자는 몇 번째로 진료를 받았는지 출력
# M_arr은 대기목록 순서의 환자 위험도 리스트
# 위험도 값이 높을수록 위험

# 진료순서 정하기
# 1. 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼냄
# 2. 나머지 대기 목록에서 꺼낸환자 보다 위험도가 높은 환자가 존재하면 
#    대기목록 제일 뒤로 다시 넣는다.

N,M = map(int,input().split())
M_arr=list(input().split())
M_queue=[]
for i in range(0,len(M_arr)):
    M_queue.append([M_arr[i],i])

M_queue=deque(M_queue)
cnt=1
while True:
    cur=M_queue.popleft()
    for j in M_queue:
        if j[0] >cur[0]:
            # 더 큰게 있음
            M_queue.append(cur)
            break
    else:
        # 더 큰게 없음
        if cur[1]==M :
            print(cnt)
            break
        else:
            cnt+=1

