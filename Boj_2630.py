def recur(y, x, N):
    global zero, one
    num = map[y][x]
    for i in range(y, y+N):
        for j in range(x, x+N):
            if num != map[i][j]:
                recur(y, x, N//2)
                recur(y, x+N//2, N//2)
                recur(y+N//2, x, N//2)
                recur(y+N//2, x+N//2, N//2)
                return
    if num == 0:
        zero += 1
    else:
        one += 1


n = int(input())
map = [list(map(int, input().split())) for _ in range(n)]
zero = 0
one = 0
recur(0, 0, n)
print(zero)
print(one)
