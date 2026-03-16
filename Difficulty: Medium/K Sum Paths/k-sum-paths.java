import java.util.*;

class Solution {
    
    public int countAllPaths(Node root, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, 0, k, map);
    }
    
    private int dfs(Node node, long currSum, int k, HashMap<Long, Integer> map) {
        if (node == null) return 0;
        
        currSum += node.data;
        
        int count = map.getOrDefault(currSum - k, 0);
        
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        count += dfs(node.left, currSum, k, map);
        count += dfs(node.right, currSum, k, map);
        
        map.put(currSum, map.get(currSum) - 1);
        
        return count;
    }
}