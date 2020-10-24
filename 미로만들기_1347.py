import sys

n = sys.stdin.readline()
list=[]
now_dir = 270

dir=sys.stdin.readline()
map_list=[]
map_list.append([0,0])
a = 0
b = 0

for i in dir :
    if i == 'R':
        now_dir+=90
        if now_dir>360 :
            now_dir-=360
    elif i == 'L' :
        now_dir-=90
        if now_dir == 0 :
            now_dir=360
    elif i == 'F' :
        if now_dir== 90 :
            a-=1
            map_list.append([a,b])
        elif now_dir == 180 :
            b+=1
            map_list.append([a, b])
        elif now_dir == 270 :
            a+= 1
            map_list.append([a,b])
        elif now_dir ==360 :
            b-=1
            map_list.append([a,b])
size_a=max(map_list,key = lambda x : x[0])[0]-min(map_list,key = lambda x : x[0])[0]+1
size_b=max(map_list,key = lambda x : x[1])[1]-min(map_list,key = lambda x : x[1])[1]+1

#print(map_list)
#print(size_b)
answer = [['#']* int(size_b) for  _ in range(int(size_a))]

set_a = min(map_list,key = lambda x : x[0])[0]
set_b = min(map_list,key = lambda x : x[1])[1]

for i in map_list :
    if set_a<0 :
        i[0] -= set_a
    if set_b<0 :
        i[1] -= set_b
for i in map_list :
    answer[i[0] ] [i[1] ] = '.'
#print(answer)
for i in range(len(answer)) :
    for j in range(len(answer[0])) :
        print(answer[i][j],end='')
    print('')

