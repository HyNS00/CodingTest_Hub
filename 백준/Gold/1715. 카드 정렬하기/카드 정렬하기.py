import sys, heapq

input = sys.stdin.readline
N = int(input())

cards = [int(input()) for i in range(N)]
heapq.heapify(cards)
answer = 0
while len(cards) != 1:
    a = heapq.heappop(cards)
    b = heapq.heappop(cards)
    sum = a+b
    answer += sum
    heapq.heappush(cards,sum)
print(answer)