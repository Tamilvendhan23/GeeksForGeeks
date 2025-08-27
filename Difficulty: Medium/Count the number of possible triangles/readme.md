# 🧮 Count the Number of Possible Triangles

## 💡 Problem Statement

Given an integer array `arr[]`, find the number of triangles that can be formed with three **different** array elements as lengths of three sides of a triangle.

A triangle is only possible if the **sum of any two sides is greater than the third side**.

### 🧠 Triangle Condition

For any 3 sides `a`, `b`, and `c`:
- `a + b > c`
- `a + c > b`
- `b + c > a`

When sorted (`a ≤ b ≤ c`), only one check is needed:
- `a + b > c`

---

## 📥 Input

- An integer array `arr[]` of size `n`

## 📤 Output

- An integer denoting the number of valid triangles

---

## 📈 Constraints

- `1 ≤ arr.length ≤ 10^3`
- `0 ≤ arr[i] ≤ 10^5`

---

## 🧪 Examples

### Example 1
Input: arr = [4, 6, 3, 7]
Output: 3

Explanation: Possible triangles are:
[3, 4, 6], [4, 6, 7], [3, 6, 7]

shell
Copy code

### Example 2
Input: arr = [10, 21, 22, 100, 101, 200, 300]
Output: 6

shell
Copy code

### Example 3
Input: arr = [1, 2, 3]
Output: 0

Explanation: No valid triangles

pgsql
Copy code

---

## ✅ Solution (Java)

```
import java.util.Arrays;

class Solution {
    public int countTriangles(int arr[]) {
        int n = arr.length;
        int count = 0;
        
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        // Step 2: Fix the third side one by one from the end
        for (int i = n - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            
            // Step 3: Use two-pointer to find valid a, b
            while (left < right) {
                if (arr[left] + arr[right] > arr[i]) {
                    // All elements from left to right-1 will form valid triangles
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return count;
    }
}
```

⏱️ Time Complexity
Sorting: O(n log n)

Two-pointers: O(n^2)

Total: O(n^2)

