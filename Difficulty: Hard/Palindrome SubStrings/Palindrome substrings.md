# Palindrome SubStrings

**Difficulty:** Hard  
**Accuracy:** 45.8%  
**Submissions:** 49K+  
**Points:** 8  
**Average Time:** 30m

## Problem Statement

Given a string `s`, count all palindromic sub-strings present in the string. The length of the palindromic sub-string must be greater than or equal to 2.

> **Note:**  
> A substring is palindromic if it reads the same forwards and backwards.

## Examples

### Example 1
**Input:**  
`s = "abaab"`

**Output:**  
`3`

**Explanation:**  
All palindromic substrings (of length > 1) are: `"aba"`, `"aa"`, `"baab"`.

---

### Example 2
**Input:**  
`s = "aaa"`

**Output:**  
`3`

**Explanation:**  
All palindromic substrings (of length > 1) are: `"aa"`, `"aa"`, `"aaa"`.

---

### Example 3
**Input:**  
`s = "abbaeae"`

**Output:**  
`4`

**Explanation:**  
All palindromic substrings (of length > 1) are: `"bb"`, `"abba"`, `"aea"`, `"eae"`.

---

## Constraints

- `2 ≤ s.size() ≤ 5000`
- `s` contains only lowercase English characters.

## Function Signature

```java
class Solution {
    public int countPS(String s) {
        // code here
    }
}
```

## Notes

- The solution should count **all** palindromic substrings of length greater than or equal to 2, including overlapping ones.
- Efficient solutions should aim for O(N²) time complexity due to constraints.
