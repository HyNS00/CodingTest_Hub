import sys

input = sys.stdin.readline

n = int(input())
party = ['ChongChong']


for _ in range(n):
    a,b= input().strip().split(' ')
    if a in party:
        party.append(b)
    elif b in party:
        party.append(a)
   
print(len(set(party)))


'''
누가 총총이와 붙어있는가 옆에 나란히 붙어있는경우를 함께 세면 된다.
중복을 피해서 계산하면 된다.

set ,dic을 함께 하면된다.
'''
