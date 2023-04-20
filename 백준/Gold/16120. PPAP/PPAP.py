import sys
input = sys.stdin.readline
pp = input().rstrip()
stack = []
ppap = ['P','P','A','P']
for word in pp :
    stack.append(word)
    # print(stack)
    if stack[-4:] == ppap :
        stack.pop()
        stack.pop()
        stack.pop()
    
if stack == ['P'] or stack == ppap:
    print('PPAP')

else :
    print('NP')