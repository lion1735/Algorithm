import sys
input = sys.stdin.readline
target = int(input())
n = int(input())
broken = list(map(int, input().split()))

res = abs(100 - target)

for nums in range(1000001):
    nums = str(nums)
    
    for j in range(len(nums)):
        if int(nums[j]) in broken:
            break

        elif j == len(nums) - 1:
            res = min(res, abs(int(nums) - target) + len(nums))

print(res)
