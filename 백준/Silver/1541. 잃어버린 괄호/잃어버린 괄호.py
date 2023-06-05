def change(num):
    return sum(list(map(int, num.split("+"))))


n = input().rstrip()

temp = list(map(change, n.split("-")))
print(temp[0] - sum(temp[1:]))
