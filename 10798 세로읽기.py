tmp_arr=[]
max_num=0
for i in range(5):
    tmp = list(input())
    max_num=max(max_num,len(tmp))
    tmp_arr.append(tmp)

for i in range(max_num):
    for j in range(len(tmp_arr)):
        if i <(len(tmp_arr[j])):
            print(tmp_arr[j][i],end = '')
       

