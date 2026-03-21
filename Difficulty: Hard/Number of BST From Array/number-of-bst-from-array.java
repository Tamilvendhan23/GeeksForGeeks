class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        Integer[][] sorted = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i][0] = arr[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, (a, b) -> a[0].compareTo(b[0]));
        
        ArrayList<Integer> fact = new ArrayList<>();
        fact.add(1);
        for (int i = 1; i <= 2 * n; i++) {
            fact.add(fact.get(i - 1) * i);
        }
        
        ArrayList<Integer> numBSTs = new ArrayList<>(Collections.nCopies(n, 0));
        for (int i = 0; i < n; i++) {
            int origIdx = sorted[i][1];
            int left = catalan(i, fact);
            int right = catalan(n - i - 1, fact);
            numBSTs.set(origIdx, left * right);
        }
        return numBSTs;
    }
    
    private int catalan(int n, ArrayList<Integer> fact) {
        if (n <= 1) return 1;
        return fact.get(2 * n) / (fact.get(n) * fact.get(n + 1));
    }
}