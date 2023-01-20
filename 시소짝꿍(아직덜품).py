'''
100 100


100 200 300 400

100 200 300 400
'''
def solution(weights):
    answer = 0
    dic = {}
    weights.sort()
    w2 = w3 = w4 = 0
    for w in weights:
        w2 = w*2
        w3 = w*3
        w4 = w*4
        w10 = w//10
        if w10 in dic:
            answer+=dic[w10]
            dic[w10] += 1
        else:
            if w2 in dic:
                answer+=dic[w2]
                dic[w2] += 1
            if w3 in dic:
                answer+=dic[w3]
                dic[w3] += 1
            if w4 in dic:
                answer+=dic[w4]
                dic[w4] += 1
            
        if w10 not in dic:
            dic[w10] = 1
        if w2 not in dic:
            dic[w2] = 1
        if w3 not in dic:
            dic[w3] = 1
        if w4 not in dic:
            dic[w4] = 1
    
    return answer
