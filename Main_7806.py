while True:
    def primeNum(m):
        arr = []
        x = m
        for i in range(2, m + 1):
            if i * i > m:
                break
            while x % i == 0:
                arr.append(i)
                x //= i
        if x != 1:
            arr.append(x)
        return arr

    def countNum(a):
        num = a
        count = 0
        while num <= n:
            count += n // num
            num *= a
        return count

    try:
        n, m = map(int, input().split())
    except:
        break
    arr = primeNum(m)
    temp = set(arr)
    res = 1

    for i in temp:
        if countNum(i) != 0:
            num = min(countNum(i), arr.count(i))
            res *= (i ** num)
    print(res)
