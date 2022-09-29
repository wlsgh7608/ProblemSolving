n = int(input())


dp = [[0,0,0] for i in range(n+1)]



for i in range(n):
    rgb = list(map(int,input().split()))
    dp[i][0] = min(dp[i-1][1],dp[i-1][2]) + rgb[0]
    dp[i][1] = min(dp[i-1][0],dp[i-1][2]) + rgb[1]
    dp[i][2] = min(dp[i-1][0],dp[i-1][1]) + rgb[2]

print(min(dp[i]))