import sys
input =sys.stdin.readline

n = int(input())
table = []
for _ in range(n):
    a,b = map(int,input().split())
    table.append((a,b))
    
sort_table = sorted(table, key = lambda x: x[0])
sort_table = sorted(sort_table, key = lambda x : x[1])

end = 0
cnt = 0
for i,j in sort_table:
    if i >= end:
        cnt += 1
        end = j
print(cnt)