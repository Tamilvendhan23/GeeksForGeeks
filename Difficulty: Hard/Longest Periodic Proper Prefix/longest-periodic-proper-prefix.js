/**
 * @param {string} s
 * @returns {number}
 */


class Solution {
  getLongestPrefix(s) {
    const n = s.length;
    if (n < 2) {
      return -1;
    }
    const mod1 = 1000000007n;
    const mod2 = 1000000009n;
    const base1 = 131n;
    const base2 = 137n;

    let pow1 = new Array(n + 1);
    let pow2 = new Array(n + 1);
    pow1[0] = 1n;
    pow2[0] = 1n;
    for (let i = 1; i <= n; i++) {
      pow1[i] = (pow1[i - 1] * base1) % mod1;
      pow2[i] = (pow2[i - 1] * base2) % mod2;
    }

    let hash1 = new Array(n + 1).fill(0n);
    let hash2 = new Array(n + 1).fill(0n);
    for (let i = 0; i < n; i++) {
      let charCode = BigInt(s.charCodeAt(i));
      hash1[i + 1] = (hash1[i] * base1 + charCode) % mod1;
      hash2[i + 1] = (hash2[i] * base2 + charCode) % mod2;
    }

    for (let k = n - 1; k >= 1; k--) {
      let len = n - k;
      let hA1 = hash1[len];
      let hA2 = hash2[len];

      let hB1 = (hash1[k + len] - ((hash1[k] * pow1[len]) % mod1)) % mod1;
      hB1 = (hB1 + mod1) % mod1;

      let hB2 = (hash2[k + len] - ((hash2[k] * pow2[len]) % mod2)) % mod2;
      hB2 = (hB2 + mod2) % mod2;

      if (hA1 === hB1 && hA2 === hB2) {
        return k;
      }
    }

    return -1;
  }
}