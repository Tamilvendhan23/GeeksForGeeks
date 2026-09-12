class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;

        // Sort the array
        java.util.Arrays.sort(arr);

        int product = 1;

        // Case 1: Largest element is 0 and k is odd → best we can do is 0
        if (arr[n - 1] == 0 && (k % 2 == 1)) {
            return 0;
        }

        // Case 2: All numbers ≤ 0 and k is odd → take k largest (least negative)
        if (arr[n - 1] <= 0 && (k % 2 == 1)) {
            for (int i = n - 1; i >= n - k; i--) {
                product *= arr[i];
            }
            return product;
        }

        int left = 0;
        int right = n - 1;

        // If k is odd, take the largest positive element
        if (k % 2 == 1) {
            product *= arr[right];
            right--;
            k--;
        }

        // Now k is even, pick pairs
        k /= 2;
        for (int i = 0; i < k; i++) {
            int leftProduct = arr[left] * arr[left + 1];
            int rightProduct = arr[right] * arr[right - 1];

            if (leftProduct > rightProduct) {
                product *= leftProduct;
                left += 2;
            } else {
                product *= rightProduct;
                right -= 2;
            }
        }

        return product;
    }
}