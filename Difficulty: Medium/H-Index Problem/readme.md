# H-Index Problem

## Problem Statement

You are given an array `citations[]`, where each element `citations[i]` represents the number of citations received by the *i-th* paper of a researcher. You have to calculate the researcher’s **H-index**.

The **H-index** is defined as the maximum value **H**, such that the researcher has published at least **H** papers, and all those papers have citation value **greater than or equal to H**.

### Constraints:
- 1 ≤ citations.length ≤ 10^6
- 0 ≤ citations[i] ≤ 10^6

## Examples

**Example 1:**
Input: citations = [3, 0, 5, 3, 0]
Output: 3
Explanation: There are at least 3 papers with citations ≥ 3 → (3, 5, 3)

```
import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {
            int count = n - i;
            if (citations[i] >= count) {
                h = count;
                break;
            }
        }

        return h;
    }
}

```
