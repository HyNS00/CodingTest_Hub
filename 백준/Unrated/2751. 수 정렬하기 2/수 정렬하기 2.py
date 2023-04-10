import sys
input = sys.stdin.readline

a = int(input())
array = []

for i in range(a):
    array.append(int(input()))
    
for re in sorted(array):
    print(re)