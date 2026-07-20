import java.util.*;

class Solution {

    // Trie node definition
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0; // number of words that share this prefix
    }

    public ArrayList<String> findPrefixes(String[] arr) {
        TrieNode root = new TrieNode();

        // 1. Build Trie and maintain counts
        for (String word : arr) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                curr.children.putIfAbsent(ch, new TrieNode());
                curr = curr.children.get(ch);
                curr.count++;    // this prefix is used by one more word
            }
        }

        // 2. For each word, find shortest unique prefix
        ArrayList<String> result = new ArrayList<>();
        for (String word : arr) {
            TrieNode curr = root;
            StringBuilder prefix = new StringBuilder();
            for (char ch : word.toCharArray()) {
                curr = curr.children.get(ch);
                prefix.append(ch);
                if (curr.count == 1) {  // unique from here
                    break;
                }
            }
            result.add(prefix.toString());
        }

        return result;
    }
}