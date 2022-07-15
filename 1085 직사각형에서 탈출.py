# 한 수는 (x,y)에 있고, 왼쪽 아래 꼭짓점은 0,0, 오른쪽 위 꼭짓점은 (w,h)
x,y,w,h=map(int,input().split())
#x,y w,h

#가까운 경우를 비교하여 최소값 설정
res = min(w-x, h-y, x,y)

print(res)