class Solution {
    public ArrayList<String> binstr(int n) {
        ArrayList<String> res = new ArrayList<>();
        int total = 1 << n; // Total possible combinations: 2^n
        for (int i = 0; i < total; i++) {
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));
            // Pad with leading zeros
            while (sb.length() < n) {
                sb.insert(0, "0");
            }
            res.add(sb.toString());
        }
        return res;
    }
}
