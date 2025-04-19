import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}
// solution is below_______________________________

class Solution {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2]; // 0 and 1
    }

    TrieNode root = new TrieNode();

    private void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }
            node = node.child[bit];
        }
    }

    private int getMaxXor(int num) {
        TrieNode node = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            // We try to take the opposite bit for maximum XOR
            if (node.child[1 - bit] != null) {
                maxXor |= (1 << i);
                node = node.child[1 - bit];
            } else {
                node = node.child[bit];
            }
        }
        return maxXor;
    }

    public int maxXor(int[] arr) {
        int max = 0;

        // Step 1: Insert all numbers into Trie
        for (int num : arr) {
            insert(num);
        }

        // Step 2: For each number, find max XOR using Trie
        for (int num : arr) {
            max = Math.max(max, getMaxXor(num));
        }

        return max;
    }
}

