class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] minMax = new int[2]; // minMax[0] = min HD, minMax[1] = max HD
        verticalSumUtil(root, 0, map, minMax);
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int hd = minMax[0]; hd <= minMax[1]; hd++) {
            result.add(map.get(hd));
        }
        return result;
    }
    
    private void verticalSumUtil(Node node, int hd, Map<Integer, Integer> map, int[] minMax) {
        if (node == null) return;
        
        // Recur for left subtree (HD decreases by 1)
        verticalSumUtil(node.left, hd - 1, map, minMax);
        
        // Add current node's value to the map for this horizontal distance
        map.put(hd, map.getOrDefault(hd, 0) + node.data);
        
        // Update min and max horizontal distances
        minMax[0] = Math.min(minMax[0], hd);
        minMax[1] = Math.max(minMax[1], hd);
        
        // Recur for right subtree (HD increases by 1)
        verticalSumUtil(node.right, hd + 1, map, minMax);
    }
}