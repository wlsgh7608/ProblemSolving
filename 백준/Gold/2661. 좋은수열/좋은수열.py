import sys
input = sys.stdin.readline

n = int(input())
arr = [0 for _ in range(n)]

def check(cur, s):
    if cur <= 1:
        return True    

    tempStr = s[::-1]
    for i in range(1, n // 2 + 1):
        temp1 = tempStr[:i]
        temp2 = tempStr[i:i+i]
        if temp1==temp2:
            return False

    return True

def recur(cur):
    if not check(cur, ''.join(map(str, arr[:cur]))):
        return
    if cur == n:
        print(''.join(map(str, arr)))
        exit()
    for i in range(1, 4):
        arr[cur] = i
        recur(cur + 1)
        arr[cur] = 0


recur(0)