def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        resOr = arr1[i] | arr2[i]
        ans = ''
        for _ in range(n):
            if resOr % 2 == 0:
                ans += ' '
            else:
                ans += '#'
            resOr //= 2
        answer.append(ans[::-1])
    return answer
