import java.util.HashMap;

class Solution {
    public boolean isSubset(int a[], int b[]) {

    int m = a.length, n = b.length;

        for (int i = 0; i < n; i++) {
            boolean found = false;

            for (int j = 0; j < m; j++) {
                if (b[i] == a[j]) {
                    found = true;
                    a[j] = -1; // mark as visited
                    break;
                }
            }

            if (!found) return false;
        }

        return true;
    
    }
}
