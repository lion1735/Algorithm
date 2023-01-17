def solution(arr):
    x = arr[0]
    arr.sort()
    for i in range(1,len(arr)):
        b = arr[i]
        a = x
        while b > 0:
            a,b = b, a%b
        x = x * arr[i] // a
    return x
