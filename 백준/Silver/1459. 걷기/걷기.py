import math

(x, y, w, s) = map(int, input().rstrip().split(" "))
if w * 2 < s:
    print((x + y) * w)
else:
    if x > y:
        answer = 0
        num = x - y
        answer += s * y
        if s < w:
            if num == 1:
                answer += w
            else:
                if num % 2 == 0:
                    answer += num // 2 * 2 * s
                else:
                    answer += num // 2 * 2 * s
                    answer += w
                    
        else:
            answer += w * num
        print(answer)
    else:
        answer = 0
        num = y - x
        answer += s * x
        if s < w:
            if num == 1:
                answer += w
            else:
                if num % 2 == 0:
                    answer += num // 2 * 2 * s
                else:
                    answer += num // 2 * 2 * s
                    answer += w
        else:
            answer += w * num
        print(answer)
