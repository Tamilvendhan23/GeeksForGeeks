def numDecodings(digits):
    if not digits or digits[0] == '0':
        return 0

    n = len(digits)
    dp = [0] * (n + 1)
    dp[0] = 1
    dp[1] = 1

    for i in range(2, n + 1):
        if 1 <= int(digits[i-1:i]) <= 9:
            dp[i] += dp[i-1]
        if 10 <= int(digits[i-2:i]) <= 26:
            dp[i] += dp[i-2]

    return dp[n]

# Examples
print(numDecodings("123"))  # Output: 3
print(numDecodings("90"))   # Output: 0
print(numDecodings("05"))   # Output: 0
