# 자리수 합 리턴
def sum_digit(num):
    sum = 0
    myNum = num

    while True:
        if num < 10:
            sum += num % 10
            break
        else:
            sum += num % 10
            num = num // 10

    return sum


sol = 0
for i in range(1, 1001):
    sol += sum_digit(i)
print(sol)