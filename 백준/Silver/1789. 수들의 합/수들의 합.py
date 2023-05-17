
a = int(input())
num = 0
answer =0
for i in range(1,a+1):
    num+= i
    answer+=1
    if num == a :
        print(answer)
        break
    elif num>a:
        print(answer-1)
        break
    