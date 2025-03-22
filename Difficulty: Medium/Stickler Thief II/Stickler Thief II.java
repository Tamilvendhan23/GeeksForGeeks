import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// answer 

class Solution {
    public int maxValue(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);

        // Case 1: Exclude the last house
        int max1 = robLinear(arr, 0, n - 2);
        // Case 2: Exclude the first house
        int max2 = robLinear(arr, 1, n - 1);

        return Math.max(max1, max2);
    }

    private int robLinear(int[] arr, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(prev1, prev2 + arr[i]);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }
}
