import sys
input = sys.stdin.readline

n,m = map(int,input().split())

names_h = []
names_s =[]
for _ in range(n):
    names_h.append(input().strip())

for _ in range(m):
    names_s.append(input().strip())
final = names_h + names_s
final.sort()
# print(final) 이렇게 하면 중복되는 것이 연속적으로 나타난다.
cnt = 0
result  =[]
for i in range(len(final)-1):
    if final[i] == final[i+1]:
        result.append(final[i])
        cnt += 1
print(cnt)
for j in result:
    print(j)
