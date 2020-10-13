import sys
n = int(sys.stdin.readline())


array=[[],[],[],[]]


for i in range(n):
    array_list=list(map(int,sys.stdin.readline().split()))
    for j in range(4):
        array[j].append(array_list[j])
result = 0

case = dict()

for i in range(n) :
    for j in range (n) :
        sum_num=array[0][i] + array[1][j]
        if sum_num in case :
            case[sum_num] +=1
        else:
            case[sum_num] = 1

for i in range(n) :
    for j in range (n) :
        sum_num= -(array[2][i] + array[3][j])
        if sum_num in case :
            result += case[sum_num]

print(result)




