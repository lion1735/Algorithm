from collections import deque
def solution(numbers, target):
    answer = 0
    size = len(numbers)
    que = deque()
    que.append([numbers[0],1])
    que.append([-numbers[0],1])
    
    while que:
        temp = que.popleft()
        num = temp[0]
        cnt = temp[1]
        if cnt == size and num == target:
            answer +=1
        
        if cnt < size:
                que.append([num+numbers[cnt],cnt+1])
                que.append([num-numbers[cnt],cnt+1])
    return answer
