import sys
input = sys.stdin.readline
m,n = map(int,input().split())
how = int(input())
width = [0,m]
height = [0,n]
for i in range(how):
    a,b = map(int,input().split())
    if a == 0:
        height.append(b)
    else :
        width.append(b)

height.sort()
width.sort()
max_result = 0

for i in range(1, len(width)):
    x =width[i] - width[i-1]
    for j in range(1, len(height)):
        y = height[j] - height[j-1]
        
        max_result = max(max_result , x*y)
print(max_result)