import sys
input = sys.stdin.readline

N = int(input())
num = N
cnt =0
while  True :
    a = num % 10  # 26 % 10 = 6
    b = num // 10 # 26 // 10  = 2
    c = (a+b) % 10 # c =8

    num = (a*10)+c   # 새로운 숫자는 마지막 a * 10  + c
    cnt +=1 
    if num == N :
        print(cnt)
        break
