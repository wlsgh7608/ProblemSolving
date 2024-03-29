def rotate(number,direct):
    if direct:
        wheels[number].appendleft(wheels[number].pop())
    else:
        wheels[number].append(wheels[number].popleft())


def check(w,d): # v=0 : 왼쪽, v=1 : 오른쪽, v = 2 : 양쪽
    l,r = w-1, w+1

    is_rotate = [False for _ in range(4)]
    is_rotate[w] = True
    for i in range(w-1,-1,-1):
        if wheels[i][2] != wheels[i+1][-2]:
            is_rotate[i] =True
        else:
            break
    for i in range(w+1,4):
        if wheels[i][-2] != wheels[i-1][2]:
            is_rotate[i] = True
        else:
            break
    for i in range(4):
        if is_rotate[i] and (w-i)%2 == 0:
            rotate(i,d)
        elif is_rotate[i] and (w-i)%2 == 1:
            rotate(i,not d)

from collections import deque
wheels = []
for _ in range(4):
    wheel = deque(list(input()))
    wheels.append(wheel)

K = int(input())
for _ in range(K):
    a,b = map(int,input().split()) # 휠, 방향
    if b == 1:
        is_right = True
    else:
        is_right = False
    check(a-1,is_right)

result = 0
for i in range(4):
    result+= int(wheels[i][0])*(2**i)



print(result)