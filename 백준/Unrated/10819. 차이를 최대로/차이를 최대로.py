import sys
from itertools import permutations

input = sys.stdin.readline

n = int(input())
array = list(map(int,input().split()))

b = list(permutations(array))
result =0
for case in b:
    total = 0
    for j in range(n-1):
        total += abs(case[j] - case[j+1])
        
    result = max(result,total)
print(result)