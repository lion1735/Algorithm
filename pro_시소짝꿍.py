def solution(weights):
    answer = 0
    dic = {}
    weights.sort()
    w2 = w3 = w4 = 0
    for w in weights:
        if w not in dic:
            dic[w] = 1
        else:
            dic[w] += 1
    for w in dic.copy().keys():
        w2 = w*2
        w3 = w*3
        w4 = w*4
        if dic[w] > 1:
            answer += (dic[w]-1)*dic[w] // 2 
        if w%3 == 0 and w4//3 in dic:
            answer += dic[w4//3] * dic[w]
        if w%2 == 0 and w3//2 in dic:
            answer += dic[w3//2] * dic[w]

    return answer
