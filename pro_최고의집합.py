'''
어차피 곱셈이 가장 크려면 중간값에서 근접한 값들이어야함.

n = 3 이고 
s = 13 이라면?
13을 4 4 5
13/3 = 4.xx
4 4 4 

'''

def solution(n, s): #n으로 나눈 평균인가?
    answer = []
    ptr = 0
    if n > s:
        return [-1]
    if s%n!=0: #나누어 떨어지지 않는다면
        ptr = 1
    for _ in range(n):
            answer.append(s//n)
    if ptr == 1:
        namerge = s - (s//n * n)
        for i in range(namerge):
            answer[i] += 1
    return sorted(answer)
