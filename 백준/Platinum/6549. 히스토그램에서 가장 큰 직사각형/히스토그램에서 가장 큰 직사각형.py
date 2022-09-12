import sys
import math
sys.setrecursionlimit(10**6)

MAX_NUM = 1_000_000_001
def init(T,A,s,e,i):
    # T: Tree , a : Array , s : start, e : end, i : idx
    if s==e:
        T[i-1] = [A[s],s]
        return T[i-1]
    mid = (s+e)//2
    left = init(T,A,s,mid,i*2)
    right = init(T,A,mid+1,e,i*2+1)

    if left[0]<right[0]:
        T[i-1] = left
    else:
        T[i-1] = right
    return T[i-1]

def query(T,ns,ne,i,qs,qe):
    # ns : node start, ne : node end
    # qs : query stary, qe : query end
    if qs>ne or qe<ns:
        return [MAX_NUM,-1]
    if qs<=ns and qe>=ne:
        return T[i-1]
    mid = (ns+ne)//2
    left = query(T,ns,mid,i*2,qs,qe)
    right = query(T,mid+1,ne,i*2+1,qs,qe)
    if left[0] < right[0]:
        return left
    else:
        return right

def solve(s,e):
    minh,idx = query(tree,0,len(h)-1,1,s,e)
    a1,a2,a3 = (e-s+1)*minh,0,0
    if idx-1 >=s:
        a2 = solve(s,idx-1)
    if idx+1 <=e:
        a3 = solve(idx+1,e)

    return max(a1,a2,a3)

while True:
    h = list(map(int,sys.stdin.readline().split()))
    if len(h) == 1 and h[0] ==0:
        break
    n = h[0]
    h = h[1:]
    tree = [MAX_NUM]*(2**(math.ceil(math.log(n,2))+1))
    init(tree,h,0,n-1,1)
    ans = solve(0,n-1)
    print(ans)
