//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

// import java.util.*;


class Solution {
    Node primeList(Node head) {
        // Precompute primes up to a sufficient limit using Sieve of Eratosthenes
        int maxLimit = 100000;
        boolean[] isPrime = new boolean[maxLimit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= maxLimit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxLimit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        Node current = head;
        while (current != null) {
            int num = current.val;
            if (isPrime[num]) {
                current = current.next;
                continue;
            }
            
            int lowerPrime = -1;
            int higherPrime = -1;
            
            // Find the nearest lower prime
            for (int i = num - 1; i >= 2; i--) {
                if (isPrime[i]) {
                    lowerPrime = i;
                    break;
                }
            }
            
            // Find the nearest higher prime
            for (int i = num + 1; i <= maxLimit; i++) {
                if (isPrime[i]) {
                    higherPrime = i;
                    break;
                }
            }
            
            int nearestPrime;
            if (lowerPrime == -1) {
                nearestPrime = higherPrime;
            } else if (higherPrime == -1) {
                nearestPrime = lowerPrime;
            } else {
                int diffLower = num - lowerPrime;
                int diffHigher = higherPrime - num;
                if (diffLower < diffHigher) {
                    nearestPrime = lowerPrime;
                } else if (diffHigher < diffLower) {
                    nearestPrime = higherPrime;
                } else {
                    nearestPrime = Math.min(lowerPrime, higherPrime);
                }
            }
            
            current.val = nearestPrime;
            current = current.next;
        }
        return head;
    }
}