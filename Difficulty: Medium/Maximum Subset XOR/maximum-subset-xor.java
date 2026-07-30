class Solution {
    public int maxSubsetXOR(int[] arr) {
        int n = arr.length;
        
        // Build XOR basis using Gaussian elimination
        int[] basis = new int[32]; // At most 32 basis elements (for 32-bit integers)
        int basisSize = 0;
        
        for (int num : arr) {
            // Try to insert num into the basis
            for (int i = 31; i >= 0; i--) {
                if ((num & (1 << i)) == 0) continue; // Skip if i-th bit is not set
                
                if (basis[i] == 0) {
                    // Found a new basis element
                    basis[i] = num;
                    basisSize++;
                    break;
                }
                
                // XOR with existing basis element to eliminate this bit
                num ^= basis[i];
            }
        }
        
        // Maximize XOR result using the basis
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            if (basis[i] != 0 && (maxXor ^ basis[i]) > maxXor) {
                maxXor ^= basis[i];
            }
        }
        
        return maxXor;
    }
}