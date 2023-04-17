
import sys
input = sys.stdin.readline
cnt =0
before =0
N = int(input())
stick = []
for i in range(N):
    b = int(input())
    stick.append(b)

for _ in range(N):
    current = stick.pop()
    if current > before:
        cnt += 1
        before = current

print(cnt)