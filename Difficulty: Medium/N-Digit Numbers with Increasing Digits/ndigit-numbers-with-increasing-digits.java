class Solution {
    
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                ans.add(i);
            }
            return ans;
        }
        
        if (n > 9) return ans;
        
        generate(n, 1, 0, ans);
        return ans;
    }
    
    private static void generate(int n, int start, int num, ArrayList<Integer> ans) {
        if (n == 0) {
            ans.add(num);
            return;
        }
        
        for (int digit = start; digit <= 9; digit++) {
            generate(n - 1, digit + 1, num * 10 + digit, ans);
        }
    }
}