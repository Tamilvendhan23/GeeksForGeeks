# Your task is to complete this function

'''

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

'''


class Solution:
    
    #Function to rotate a linked list.
    def rotate(self, head, k):
        # code here
        if not head or k == 0:  # Empty list or no rotations
            return head
    
        # Step 1: Calculate the length of the list
        length = 1
        current = head
        while current.next:
            current = current.next
            length += 1
    
        # Step 2: Find effective rotations
        k %= length
        if k == 0:  # No rotation needed
            return head
    
        # Step 3: Connect the tail to the head to form a circular list
        current.next = head
    
        # Step 4: Traverse to the k-th node (new tail)
        new_tail_position = k
        new_tail = head
        for _ in range(new_tail_position - 1):
            new_tail = new_tail.next
    
        # Step 5: Adjust pointers to break the loop and set the new head
        new_head = new_tail.next
        new_tail.next = None
    
        return new_head

# Helper functions to create and display a linked list
def createLinkedList(values):
    if not values:
        return None
    head = ListNode(values[0])
    current = head
    for val in values[1:]:
        current.next = ListNode(val)
        current = current.next
    return head  



#{ 
 # Driver Code Starts
#Initial Template for Python 3


# Define the Node class for the linked list
class Node:

    def __init__(self, x):
        self.data = x
        self.next = None


# Function to print the linked list
def printList(node):
    while node:
        print(node.data, end=" ")
        node = node.next
    print()


#Position this line where user code will be pasted.

# Main function
if __name__ == "__main__":
    import sys
    input = sys.stdin.read
    data = input().splitlines()

    t = int(data[0].strip())
    idx = 1

    while t > 0:
        arr = list(map(int, data[idx].strip().split()))

        head = None
        if arr:
            head = Node(arr[0])
            tail = head
            for num in arr[1:]:
                tail.next = Node(num)
                tail = tail.next

        k = int(data[idx + 1].strip())
        idx += 2
        head = Solution().rotate(head, k)
        printList(head)
        print("~")
        t -= 1

# } Driver Code Ends