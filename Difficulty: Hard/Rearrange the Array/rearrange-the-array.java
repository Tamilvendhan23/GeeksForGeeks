class Solution {
    static final int MOD = 1000000007;

    private long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    public int minOperations(int[] b) {
        int n = b.length;

        // 1. Find cycle lengths
        boolean[] vis = new boolean[n];
        java.util.List<Integer> cycles = new java.util.ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int len = 0;
                int cur = i;
                while (!vis[cur]) {
                    vis[cur] = true;
                    cur = b[cur] - 1; // convert to 0-based
                    len++;
                }
                cycles.add(len);
            }
        }

        // 2. Build SPF (smallest prime factor) up to n
        int[] spf = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            spf[i] = i;
        }
        for (int i = 2; (long) i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        // 3. Compute maximum exponent of each prime across all cycle lengths
        java.util.Map<Integer, Integer> maxPower = new java.util.HashMap<>();

        for (int length : cycles) {
            int len = length;
            java.util.Map<Integer, Integer> freq = new java.util.HashMap<>();

            while (len > 1) {
                int p = spf[len];
                int cnt = 0;
                while (len % p == 0) {
                    len /= p;
                    cnt++;
                }
                freq.put(p, cnt);
            }

            for (java.util.Map.Entry<Integer, Integer> e : freq.entrySet()) {
                int prime = e.getKey();
                int cnt = e.getValue();
                maxPower.merge(prime, cnt, Math::max);
            }
        }

        // 4. Reconstruct LCM under modulo
        long res = 1;
        for (java.util.Map.Entry<Integer, Integer> e : maxPower.entrySet()) {
            int prime = e.getKey();
            int exp = e.getValue();
            res = (res * modPow(prime, exp)) % MOD;
        }

        return (int) res;
    }
}