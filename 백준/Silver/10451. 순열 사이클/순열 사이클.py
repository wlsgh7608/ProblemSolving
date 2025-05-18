import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(s,current):
    global cnt
    next = G[s]
    if next in current:
        cnt+=1
        return 
    else:
        visited[next] = True
        current.append(next)
        dfs(next,current)



T = int(input())
for _ in range(T):
    cnt = 0
    n = int(input())
    G = list(map(int,input().split()))
    G = [x-1 for x in G]
    visited = [False for _ in range(n)]
    for i in range(n):
        if not visited[i]:
            dfs(i,[]) 
    print(cnt)



