a, b = map(int, input().split(" "))
c = int(input())
nextTime = b + c
while nextTime >= 60:
    nextTime -= 60
    a += 1
    if a >= 24:
        a = 0

print(f'{a} {nextTime}')
