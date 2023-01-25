'''

9
5
34
3
30

1000이하니까

10만 이하의 길이

1,2,3,4 의 공배수 12 자리 로 맞추기

'''


def solution(numbers):
    answer = ''
    arr = []
    for i in range(len(numbers)):
        arr.append([(12//len(str(numbers[i]))) * str(numbers[i]),numbers[i]])
    arr.sort(reverse=True)
    for i in arr:
        answer += str(i[1])
    if int(answer) == 0:
        return '0'
    return answer
