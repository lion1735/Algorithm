answer = 0
def solution(ability):
    size = len(ability)
    act = len(ability[0])
    visited = [False] * size
    result = [0] * act
        
    def recur(visited, result, depth):
        global answer
        if act == depth:
            answer = max(answer, sum(result))
        else:    
            for i in range(size):
                if not visited[i] :
                    visited[i] = True
                    result[depth] = int(ability[i][depth])
                    recur(visited, result, depth+1)
                    visited[i] = False
    recur(visited,result, 0)
    return answer
