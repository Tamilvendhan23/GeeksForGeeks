# Array Duplicates - GeeksforGeeks Practice Problem

**Difficulty**: Easy  
**Accuracy**: 18.95%  
**Submissions**: 873K+  
**Points**: 2  
**Average Time**: 20m

## Problem Statement

Given an array `arr[]` of size `n`, containing elements from the range `1` to `n`, and each element appears **at most twice**, return an array of all the integers that appear twice.

**Note**: You can return the elements in any order but the driver code will print them in sorted order.

### Examples


### Constraints
- `1 ≤ n ≤ 10^6`
- `1 ≤ arr[i] ≤ n`

## Approach

### Key Insights
1. **Range Constraint**: Elements are in `[1, n]` range, so index `x-1` represents value `x`
2. **Frequency Constraint**: Each element appears **at most twice**
3. **In-place Marking**: Use the sign of array elements to track visits (negative = visited)

### Algorithm (O(n) time, O(1) space)

## How It Works

### Example Walkthrough: `[2, 3, 1, 2, 3]`

| Step | i | arr[i] | val | idx | arr[idx] | Action | arr state |
|------|---|--------|-----|-----|----------|--------|-----------|
| 0 | 0 | 2 | 2 | 1 | 3 (>0) | Mark negative | `[2,-3,1,2,3]` |
| 1 | 1 | -3 | 3 | 2 | 1 (>0) | Mark negative | `[2,-3,-1,2,3]` |
| 2 | 2 | -1 | 1 | 0 | 2 (>0) | Mark negative | `[-2,-3,-1,2,3]` |
| 3 | 3 | 2 | 2 | 1 | -3 (<0) | **Duplicate 2** | `[-2,-3,-1,2,3]` |
| 4 | 4 | 3 | 3 | 2 | -1 (<0) | **Duplicate 3** | `[-2,-3,-1,2,3]` |

**Result**: `[2, 3]`

## Complexity Analysis

| Metric | Complexity | Reason |
|--------|------------|---------|
| **Time** | O(n) | Single pass through array |
| **Space** | O(1) | Only output array (in-place modification) |

## Why This Works
- ✅ **Range `[1,n]`** → Perfect for index mapping
- ✅ **At most twice** → Sign bit sufficient for tracking
- ✅ **No extra space** → Clever use of array signs
- ✅ **Stable** → Original array values recoverable by taking absolute values

## Alternative Approaches

| Approach | Time | Space | Pros | Cons |
|----------|------|-------|------|------|
| HashSet | O(n) | O(n) | Simple | Extra space |
| Sorting | O(n log n) | O(1) | In-place | Slower |
| Counting | O(n) | O(n) | Clear logic | Extra space |

## Key Takeaways
- **Index = value - 1** for `[1,n]` range problems
- **Sign bit manipulation** for frequency tracking (0/1 → unvisited/visited)
- **Math.abs()** to handle negative marking during iteration
- Perfect for **placement interviews** due to optimal complexity
