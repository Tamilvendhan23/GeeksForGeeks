class Solution {
  public:
    string maxSubseq(string& s, int k) {
        int n = s.size();
        int keep = n - k;
        string result = "";
        
        for (char c : s) {
            // Remove smaller chars from end of result if possible
            while (!result.empty() && result.back() < c && k > 0) {
                result.pop_back();
                k--;
            }
            result.push_back(c);
        }

        // Only keep the first 'keep' characters
        result.resize(keep);
        return result;
    }
};
