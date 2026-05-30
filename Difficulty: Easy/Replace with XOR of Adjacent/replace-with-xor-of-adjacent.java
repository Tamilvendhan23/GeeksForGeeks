class Solution {
    public void replaceElements(int[] arr) {
        int n = arr.length;
        
        // Handle edge case
        if (n <= 1) return;
        
        // Store the original value of arr[0] before updating
        int prev = arr[0];
        
        // Update first element: arr[0] ^ arr[1]
        arr[0] = arr[0] ^ arr[1];
        
        // Update middle elements: prev ^ arr[i+1]
        for (int i = 1; i < n - 1; i++) {
            int curr = arr[i];        // Store current value before overwriting
            arr[i] = prev ^ arr[i + 1]; // XOR of original previous and next
            prev = curr;               // Update prev for next iteration
        }
        
        // Update last element: original arr[n-2] ^ arr[n-1]
        arr[n - 1] = prev ^ arr[n - 1];
    }
}