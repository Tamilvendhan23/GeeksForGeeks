class Solution {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(result, arr, 0);
        return result;
    }
    
    private static void backtrack(ArrayList<ArrayList<Integer>> result, int[] arr, int index) {
        if (index == arr.length) {
            ArrayList<Integer> perm = new ArrayList<>();
            for (int num : arr) {
                perm.add(num);
            }
            result.add(perm);
            return;
        }
        
        for (int i = index; i < arr.length; i++) {
            // Swap
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
            
            // Recurse
            backtrack(result, arr, index + 1);
            
            // Backtrack
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
};
