check = []
vector = []
set_list = set()


def isPrime(n):
    prime = True
    if n == 1 or n == 0:
        return False

    for i in range(2, int(n / 2) + 1, 1):
        if n % i == 0:
            prime = False
            break
    return prime


def exchange(vector):
    str_val = ""
    for i in vector:
        str_val = str_val + i
    return int(str_val)


def solve(numbers, cnt, end):
    global check, vector, set_list

    if cnt == end:
        num = exchange(vector)
        set_list.add(num)
        return

    for i, value in enumerate(numbers):
        if check[i] == False:
            check[i] = True
            vector.append(value)
            solve(numbers, cnt + 1, end)
            vector.pop()
            check[i] = False


def solution(numbers):
    global check, vector, set_list
    answer = 0
    for end in range(1, len(numbers) + 1, 1):
        check = [False for i in range(0, 7, 1)]
        vector = []
        solve(numbers, 0, end)
    for i in set_list:
        if isPrime(i):
            answer += 1
    return answer