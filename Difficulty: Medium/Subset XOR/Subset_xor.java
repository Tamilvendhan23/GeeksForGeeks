class Solution {
    public static ArrayList<Integer> subsetXOR(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        // XOR of 1..n in O(1)
        int xorVal;
        int rem = n % 4;
        if (rem == 0) xorVal = n;
        else if (rem == 1) xorVal = 1;
        else if (rem == 2) xorVal = n + 1;
        else xorVal = 0;

        int removeVal = -1;
        if (xorVal != n) {
            removeVal = xorVal ^ n;  // value to remove
        }

        for (int i = 1; i <= n; i++) {
            if (i == removeVal) continue;  // skip exactly this one (if any)
            ans.add(i);
        }
        return ans;
    }
}
