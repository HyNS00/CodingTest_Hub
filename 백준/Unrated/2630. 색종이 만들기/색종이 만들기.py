import sys
input = sys.stdin.readline
N = int(input())
lst = []
for _ in range(N):
    lst.append(list(map(int,input().split())))

def conqure(n,lst):
    if not any(1 in i for i in lst):
        lst_cnt.append(0)

        return
    
    elif not any(0 in i for i in lst):
        lst_cnt.append(1)

        return
    
    else :
        lst_0= []
        lst_1 = []
        for i in lst:
            lst_0.append(i[:n//2])
            lst_1.append(i[n//2:])

        conqure(n//2 , lst_0[:n//2])
        conqure(n//2, lst_0[n//2:])
        conqure(n//2 ,lst_1[n//2:])
        conqure(n//2, lst_1[:n//2])

        return
    
lst_cnt = []
conqure(N,lst)

print(lst_cnt.count(0))
print(lst_cnt.count(1))