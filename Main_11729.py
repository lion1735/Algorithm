def recur(cur, s, e) :
    if cur == 1 :
        print(s, e)
        return
       
    recur(cur-1, s, 6-s-e)
    print(s, e) 
    recur(cur-1, 6-s-e, e) 
    
n = int(input())
print(2**n-1)
recur(n, 1, 3)
