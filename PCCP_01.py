'''
2회 이상 나타난 알파벳
2개 이상의 부분으로 나뉘어 있으면

1개만 찾았을때 같은 알파벳이 안나올때까지 패스
eeeeede
다음 카운팅 했을때 2개가 되면 외톨이 알파벳
'''


def solution(input_string):
    dic ={}
    answer = []
    prev = ''
    for char in input_string:
        if char == prev:
            continue
        if char not in dic:
            dic[char] = 1
        else:
            dic[char]+=1
            if dic[char] == 2:
                answer.append(char)
        prev = char
    if len(answer) == 0:
        return 'N'
    else:
        answer.sort()
        return ''.join(answer)
