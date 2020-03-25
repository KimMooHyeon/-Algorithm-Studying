T = int(input())

for test_case in range(1, T + 1):
    N=int(input())
    ai=[]
    ai_cnt=[]
    num_list= input()
    for i in range (0,N):
        ai.append(int(num_list[i]))
    ai.sort()
    ai.reverse()
    print(ai)
    for i in range(0, N):
        ai_cnt.append(ai.count(ai[i]))
    print(ai_cnt)

    print("#{} {} {}".format(test_case,ai[ai_cnt.index(max(ai_cnt))],max(ai_cnt)))
