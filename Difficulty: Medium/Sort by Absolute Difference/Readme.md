# Sort by Absolute Difference

### Difficulty: Medium  
**Accuracy:** 27.77%  
**Platform:** [GeeksforGeeks Problem Link](https://www.geeksforgeeks.org/problems/sort-by-absolute-difference-1587115621/1)

---

## Problem Statement

You are given a number `x` and an array `arr[]`. Your task is to rearrange the elements of the array according to the absolute difference with `x`. Elements with the **minimum difference** should come **first**, and if two or more elements are at **equal distances**, they must maintain the **same sequence** as in the original array.

---

## Examples

### Example 1:
**Input:**  
`x = 7`,  
`arr[] = [10, 5, 3, 9, 2]`  

**Output:**  
`[5, 9, 10, 3, 2]`  

**Explanation:**  
Sorted by absolute difference with 7 →  
`abs(10-7)=3`, `abs(5-7)=2`, `abs(3-7)=4`, `abs(9-7)=2`, `abs(2-7)=5`  
So order becomes: `5, 9, 10, 3, 2`

---

### Example 2:
**Input:**  
`x = 6`,  
`arr[] = [1, 2, 3, 4, 5]`  

**Output:**  
`[5, 4, 3, 2, 1]`  

---

## Constraints

- `1 ≤ x ≤ 10^5`  
- `1 ≤ arr.length ≤ 10^5`  
- `1 ≤ arr[i] ≤ 10^5`

---

## Approach

- Create a list of pairs where each pair contains the element and its original index.
- Sort the list based on:
  - Absolute difference with `x`
  - Original index (to preserve order for equal differences)
- Write the sorted values back into the original array.

This ensures a **stable sort** based on the absolute difference, which is essential to maintain relative order when differences are equal.

---

## Java Implementation

```java
import java.util.*;

class Solution {
    public void rearrange(int[] arr, int x) {
        // Create a list of pairs [value, original index]
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new int[]{arr[i], i});
        }

        // Sort by absolute difference; maintain original order on tie
        list.sort((a, b) -> {
            int diffA = Math.abs(a[0] - x);
            int diffB = Math.abs(b[0] - x);
            if (diffA != diffB) {
                return diffA - diffB;
            } else {
                return a[1] - b[1];  // Maintain original order if same difference
            }
        });

        // Update the original array with sorted values
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i)[0];
        }
    }
}
