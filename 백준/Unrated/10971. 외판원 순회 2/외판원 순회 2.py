from itertools import permutations
import sys
input = sys.stdin.readline

N = int(input())
price = [] 
for i in range(N):
    price.append(list(map(int,input().split())))

def main(N,price):
    answer = sys.maxsize
    # 들러야할 경로들을 표현
    arr = [i for i in range(N)]
    permuarr = list(permutations(arr,N))
    for i in permuarr:
        totalsum = 0
        possible = True
        # 앞선 순열에서 짠 경로를 토대로 그대로 이동
        for j in range(N-1):
            # 만약 이동한 값이었다면 그대로 사용
            if price[i[j]][i[j+1]] != 0:
                totalsum += price[i[j]][i[j+1]]

            else :
                possible = False
                break
        if price[i[-1]][i[0]] != 0:  # 마지막 끝으로 돌아가는 코드
            totalsum += price[i[-1]][i[0]] 

        else :
            possible = False
        # possible 를 토대로 값을 도출
        if possible == True:
            answer = min(answer,totalsum)

    return answer
print(main(N,price))
