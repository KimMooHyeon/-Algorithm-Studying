T = int(input())

for test_case in range(1, T + 1):
    tmp=input()
    tmp=list(tmp)
    for i in range(0,len(tmp)//2):
      
        if tmp[i] != tmp[-i-1]:
            print(f"#{test_case} 0")
            break
    else:
        print(f"#{test_case} 1")

