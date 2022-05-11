'''
x + y + z = n
x = y -2
z % 2 == 0

택희는 짝수
남규는 영훈이 +2
영훈이는 i

N개에서 택희가 i개를 가져갈 때
N-i-2개를 2명이 나눠가지는 방법을 계산
경우의 수는 (N-i-2)/2 개
'''
n = int(input())
cnt = 0
for i in range(2, n-1, 2):
    cnt += (n-i-2)//2
print(cnt)
