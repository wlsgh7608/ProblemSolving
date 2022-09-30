import sys
from collections import deque
input = sys.stdin.readline

K = int(input())
W,H = map(int,input().split())
G = [list(map(int,input().split())) for _ in range(H)]
horse_x = [2,2,1,1,-1,-1,-2,-2]
horse_y = [-1,1,-2,2,-2,2,-1,1]
X  = [-1,1,0,0]
Y  = [0,0,-1,1]
visited = [[0 for _ in range(W)] for _ in range(H)]
visited[0][0] = K+1


def is_new_dict(x,y,dx,dy,horses):
    nx,ny = x+dx, y+dy
    if 0<=nx<H and 0<=ny < W:
        if  G[nx][ny]== 0:
            if visited[nx][ny]-1 < horses:
                visited[nx][ny] = horses+1
                return True
    return False

def bfs():
    answer = -1
    Q = deque()
    Q.append([(0,0),K,0])

    while Q:
        (x,y),jump,cnt = Q.popleft()
        if x == H-1 and y == W-1:
            answer  = cnt
            break
        if jump>0:
            for hx,hy in zip(horse_x,horse_y):
                ans = is_new_dict(x,y,hx,hy,jump-1)
                if ans:
                    Q.append([(x+hx,y+hy),jump-1,cnt+1])
        for dx,dy in zip(X,Y):
            ans = is_new_dict(x,y,dx,dy,jump)
            if ans:
                Q.append([(x+dx,y+dy),jump,cnt+1])
    print(answer)
bfs()