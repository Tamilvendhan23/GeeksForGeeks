# Form the Largest Number

**Difficulty:** Medium  
**Accuracy:** 37.82%  
**Submissions:** 175K+  
**Points:** 4

---

## Problem Statement
Given an array of integers `arr[]` representing non-negative integers, arrange them so that after concatenating all of them in order, it results in the largest possible number. Since the result may be very large, return it as a string.

---

## Examples

### Example 1
**Input:**  
```
arr[] = [3, 30, 34, 5, 9]
```
**Output:**  
```
9534330
```
**Explanation:**  
Given numbers are `[3, 30, 34, 5, 9]`, the arrangement `[9, 5, 34, 3, 30]` gives the largest value.

---

### Example 2
**Input:**  
```
arr[] = [54, 546, 548, 60]
```
**Output:**  
```
6054854654
```
**Explanation:**  
Given numbers are `[54, 546, 548, 60]`, the arrangement `[60, 548, 546, 54]` gives the largest value.

---

### Example 3
**Input:**  
```
arr[] = [3, 4, 6, 5, 9]
```
**Output:**  
```
96543
```
**Explanation:**  
Given numbers are `[3, 4, 6, 5, 9]`, the arrangement `[9, 6, 5, 4, 3]` gives the largest value.

---

## Constraints
- `1 ≤ arr.size() ≤ 10^5`
- `0 ≤ arr[i] ≤ 10^5`

---

## Approach
This is a **custom sorting problem**:
- Compare two numbers `a` and `b` by checking which concatenation gives a bigger number:
  - If `(a + b) > (b + a)` → `a` should come before `b`.
  - Otherwise, `b` comes before `a`.
- Convert all numbers to strings and sort using this comparator.
- Concatenate the sorted array to form the result.
- Handle edge case: if the highest number is `0`, return `"0"`.

---

## Java Solution
```java
import java.util.*;

class Solution {
    public String findLargest(int[] arr) {
        // Convert integers to strings
        String[] nums = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = String.valueOf(arr[i]);
        }

        // Custom comparator: sort by (b+a) vs (a+b)
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // descending order
            }
        });

        // If largest number is "0", return "0"
        if (nums[0].equals("0")) {
            return "0";
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }
}
```

---

## Key Idea
The challenge lies in defining the **sorting rule**. By comparing concatenations (`a+b` vs `b+a`), we ensure that numbers are ordered to form the largest concatenated result.
