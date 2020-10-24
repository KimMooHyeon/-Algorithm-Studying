import sys

visit=[[False] * 6 for _ in range(6)]

check = 0
first_a=0
first_b=0
night_list=[]
for i in range(36) :
    night = sys.stdin.readline().rstrip()
    night_list.append(night)


for i in range(36) :

    if i == 0 :
        b = ord(night_list[i][0]) - 65
        a = 6 - int(night_list[i][1])
        visit[a][b] = True
        first_a=a
        first_b=b
        continue

    n_a = 6 - int(night_list[i][1])
    n_b = ord(night_list[i][0]) - 65
    if (n_a == a+1 and n_b == b-2 ) or (n_a == a+1 and n_b == b+2 ) or (n_a == a-1 and n_b == b+2 ) or (n_a == a-1 and n_b == b-2 ) or(n_a == a+2 and n_b == b-1 ) or (n_a == a+2 and n_b == b+1 ) or  (n_a == a-2 and n_b == b+1 ) or (n_a == a-2 and n_b == b-1 ):
        pass
    else:
        #print(night)
        check =1
        break

    b = ord(night_list[i][0])-65
    a = 6-int(night_list[i][1])
    #print(a,b)
    if visit[a][b] == True :
        #print("실패야")
        #print('InValid')
        check = 1
       # print(night)

    else:
        visit[a][b] = True

for i in range(6) :
    for j in range(6):
        if visit[i][j] == False :
            check = 1
            break
#print(visit[4][2])

if (first_a == a + 1 and first_b == b - 2) or (first_a == a + 1 and first_b == b + 2) or (first_a == a - 1 and first_b == b + 2) or (
        first_a == a - 1 and first_b == b - 2) or (first_a == a + 2 and first_b == b - 1) or (first_a == a + 2 and first_b == b + 1) or (
        first_a == a - 2 and first_b == b + 1) or (first_a == a - 2 and first_b == b - 1):
    if check == 0:
        print('Valid')
    else:
        print('Invalid')
else:
    print('Invalid')



