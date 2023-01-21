def solution(storey):
    answer = 0

    while storey:
        remainder = storey % 10
        # 큰 정수로 만들기
        if remainder > 5:
            answer += (10 - remainder)
            storey += 10
        # 작은 정수로 만들기
        elif remainder < 5:
            answer += remainder
        # 5일때
        else:
            if (storey // 10) % 10 > 4:
                storey += 10
            answer += remainder
        storey //= 10

    return answer
