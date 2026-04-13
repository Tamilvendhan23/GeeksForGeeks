class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;

        boolean all9 = true;
        for (int x : num) {
            if (x != 9) {
                all9 = false;
                break;
            }
        }
        if (all9) {
            int[] ans = new int[n + 1];
            ans[0] = 1;
            ans[n] = 1;
            return ans;
        }

        int i = n / 2 - 1;
        int j = (n % 2 == 0) ? n / 2 : n / 2 + 1;

        while (i >= 0 && num[i] == num[j]) {
            i--;
            j++;
        }

        boolean leftSmaller = (i < 0 || num[i] < num[j]);

        while (i >= 0) {
            num[j] = num[i];
            i--;
            j++;
        }

        if (leftSmaller) {
            int carry = 1;
            i = n / 2 - 1;

            if (n % 2 == 1) {
                num[n / 2] += carry;
                carry = num[n / 2] / 10;
                num[n / 2] %= 10;
                j = n / 2 + 1;
            } else {
                j = n / 2;
            }

            while (i >= 0) {
                num[i] += carry;
                carry = num[i] / 10;
                num[i] %= 10;
                num[j] = num[i];
                i--;
                j++;
            }
        }

        return num;
    }
}