N = int(input())
arr = [0 for i in range(N)]
visited = [False for i in range(N)]


def check(cur):
    for i in range(cur):
        if arr[i] == arr[cur] or abs(i-cur) == abs(arr[i]-arr[cur]):
            return False
    return True


def recur(cur):
    global cnt
    if cur == N:
        cnt += 1
        return
    for i in range(N):
        if visited[i]:
            continue
        arr[cur] = i
        visited[i] = True
        if check(cur):
            recur(cur+1)
        visited[i] = False


cnt = 0
recur(0)
print(cnt)
