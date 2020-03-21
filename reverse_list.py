numbers = [2, 4, 6, 8, 10, 12, 14]
for i in range(0, len(numbers) // 2):
    print(i)
    temp = numbers[i]
    numbers[i] = numbers[-i - 1]
    numbers[-i - 1] = temp

# 리스트 뒤집기
# 코드를 입력하세요.

print("뒤집어진 리스트: " + str(numbers))