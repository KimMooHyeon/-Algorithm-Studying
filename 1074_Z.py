import sys

N, r, c = map(int, sys.stdin.readline().split())


def solve(N, r, c, num):

    if N == -1:
        print(num)
        return

    if c < ((2 ** N) / 2):
        if r < ((2 ** N) / 2):
            pass
        else:
            num += (2**(2*N - 2) * 2)
            r -= ((2 ** N) // 2)
    else:
        if r < ((2 ** N) // 2):
            num += (2**(2*N - 2))
            c -= ((2 ** N) // 2)
        else:
            num += (2**(2*N - 2) * 3)
            r -= ((2 ** N) // 2)
            c -= ((2 ** N) // 2)

    solve(N - 1, r, c, num)

solve(N, r, c, 0)
