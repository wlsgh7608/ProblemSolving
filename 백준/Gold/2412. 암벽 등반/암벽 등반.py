import sys
input = sys.stdin.readline
from collections import deque
n, t = map(int, input().split())
ls = set(tuple(map(int, input().split())) for _ in range(n))
def bfs(x, y):
    visited = set()
    visited.add((x, y))
    q = deque()
    q.append((x, y, 0))
    while q:
        cur_x, cur_y, cur_cnt = q.popleft()
        if cur_y == t:
            return cur_cnt
        for ny in range(cur_y + 2, cur_y - 3, -1):
            for nx in range(cur_x + 2, cur_x - 3, -1):
                if (nx, ny) in visited:
                    continue
                if not (nx, ny) in ls:
                    continue
                q.append((nx, ny, cur_cnt + 1))
                visited.add((nx, ny))
    return -1
print(bfs(0, 0))