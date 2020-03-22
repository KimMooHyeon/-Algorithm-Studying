T = int(input())
sol=[]
for test_case in range(1, T + 1):
    num_all = int(input())
    num_list=list(map(int, input().split()))
    sol.append(max(num_list)-min(num_list))
for i in range (0,len(sol)) :
    print("#{} {}".format(i+1,sol[i]))