# Find Length of Loop in Linked List

**Difficulty:** Medium  
**Accuracy:** 44.26%  
**Submissions:** 278K+  
**Points:** 4  
**Average Time:** 30m

---

## Problem Statement

Given the `head` of a linked list, determine whether the list contains a **loop** (cycle).  
If a loop is present, **return the number of nodes in the loop**; otherwise, return `0`.

> Internally, `pos` (1-based index) denotes the position of the node that the tail's next pointer is connected to.  
> If `pos = 0`, the last node points to `null`, indicating no loop. `pos` is not passed as a parameter.

---

## Examples

### Example 1

Input: pos = 2
Linked List: 1 → 2 → 3 → 4 → (back to node 2)

Output: 4
Explanation: There exists a loop in the linked list and the length of the loop is 4.

text

### Example 2

Input: pos = 3
Linked List: 19 → 33 → 10 → (back to node 19)

Output: 3
Explanation: The loop is from 19 to 10. So length of loop is 19 → 33 → 10 = 3.

text

### Example 3

Input: pos = 0
Linked List: 1 → 2 → 3 → 4

Output: 0
Explanation: There is no loop.

text

---

## Constraints

- \( 1 \leq \text{number of nodes} \leq 10^5 \)
- \( 1 \leq \text{node->data} \leq 10^4 \)
- \( 0 \leq \text{pos} < \text{number of nodes} \)

---

## Approach

- Use Floyd's Cycle Detection Algorithm (Tortoise and Hare):
    - Traverse with two pointers (`slow` moves one step, `fast` moves two steps).
    - If they meet, a cycle exists. To get the loop length, move one pointer, counting steps until pointers meet again.
    - Return the count if loop exists; else, return 0.

---

## Java Solution

/*
class Node {
int data;
Node next;
Node(int x) {
data = x;
next = null;
}
}
*/
