def solution(k, tangerine):
    answer = 0
    dic = {}
    for t in tangerine:
        if t not in dic:
            dic[t] = 1
        else:
            dic[t] += 1
    for data in sorted(dic.items(),key=lambda x:x[1],reverse=True):
        if k <= 0:
            answer+=1
        else :
            k -= data[1]    
    return len(dic)-answer
