class Solution {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // For ordered output and easier duplicate handling
        boolean[] used = new boolean[arr.length];
        backtrack(arr, new ArrayList<>(), used, result);
        return result;
    }
    
    private static void backtrack(int[] arr, ArrayList<Integer> curr, boolean[] used, ArrayList<ArrayList<Integer>> result) {
        if (curr.size() == arr.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // Skip used elements
            if (used[i]) continue;
            // Skip duplicates (only pick the first unused duplicate in each recursion)
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;
            
            used[i] = true;
            curr.add(arr[i]);
            backtrack(arr, curr, used, result);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}
