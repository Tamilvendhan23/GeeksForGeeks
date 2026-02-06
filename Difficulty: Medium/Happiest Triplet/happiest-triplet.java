class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        
        int n = a.length;
        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        int[] res = new int[3];
        
        while (i < n && j < n && k < n) {
            int mn = Math.min(Math.min(a[i], b[j]), c[k]);
            int mx = Math.max(Math.max(a[i], b[j]), c[k]);
            int diff = mx - mn;
            int sum = a[i] + b[j] + c[k];
            
            if (diff < minDiff || (diff == minDiff && sum < minSum)) {
                minDiff = diff;
                minSum = sum;
                res[0] = a[i];
                res[1] = b[j];
                res[2] = c[k];
            }
            
            if (a[i] == mn) i++;
            else if (b[j] == mn) j++;
            else k++;
        }
        
        // Sort descending: largest to smallest
        Arrays.sort(res);
        int temp = res[0];
        res[0] = res[2];
        res[2] = temp;
        return res;
    }
}
