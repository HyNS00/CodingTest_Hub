n = int(input())
array = []
for i in range(n):
    array.append(input())
array_r = list(set(array))    
array_r.sort()
array_r.sort(key = lambda x: len(x))
for a in array_r:
    print(a)