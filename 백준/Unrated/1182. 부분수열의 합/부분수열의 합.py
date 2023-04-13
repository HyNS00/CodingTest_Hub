import sys
from itertools import combinations
cnt = 0
input = sys.stdin.readline
N,S = map(int,input().split())
array = list(map(int,input().split()))

for i in range(N):
    b = combinations(array,i+1)
    for comb in b:
        if sum(comb) == S:
            cnt +=1

print(cnt)