n = int(input())
cnt = 0
A = [0 for _ in range(n+1)]
B = [0 for _ in range(n+1)]
C = [0 for _ in range(n+1)]
for i in range(1, n+1):
    m = input()
    if m == 'P':
        A[i] = A[i-1] + 1
        B[i] = B[i-1]
        C[i] = C[i-1]
    elif m == 'H':
        A[i] = A[i-1]
        B[i] = B[i-1] + 1
        C[i] = C[i-1]
    elif m == 'S':
        A[i] = A[i-1]
        B[i] = B[i-1]
        C[i] = C[i-1] + 1
for i in range(1, n+1):
    cnt = max(cnt, A[i]+B[n]-B[i], A[i]+C[n]-C[i], B[i]+C[n] -
              C[i], B[i]+A[n]-A[i], C[i]+B[n]-B[i], C[i]+A[n]-A[i])
cnt = max(cnt, A[n], B[n], C[n])
print(cnt)
