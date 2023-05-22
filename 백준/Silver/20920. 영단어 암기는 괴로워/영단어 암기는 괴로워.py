import sys
input = sys.stdin.readline

n,m = map(int,input().split())
dic = {}
result = []
for _ in range(n):
    a = input().strip()
    
    if len(a) >= m:
       
        if a in dic :
            dic[a] += 1

        else : 
            dic[a] = 1
# 갯수대로 받기

result = sorted(dic.items(),key = lambda x : (-x[1], -len(x[0]), x[0]))

for i in range(len(result)):
    print(result[i][0])


'''
에러 해결
주어진 에러는 "TypeError: sorted expected 1 argument, got 2"입니다. 이 에러는 sorted() 함수에 인자로 전달된 값이 예상과 다른 개수로 전달되었을 때 발생힌다.

sorted() 함수는 정렬된 새로운 리스트를 반환하는 함수이며, 정렬하고자 하는 요소들을 인자로 받습니다. 일반적으로 sorted() 함수는 단일 인자로 사용되며, 
정렬할 리스트나 이터러블 객체를 전달한다. 하지만 해당 에러는 두 개의 인자를 전달했을 때 발생.

'''