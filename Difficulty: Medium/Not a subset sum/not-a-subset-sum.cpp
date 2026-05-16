class Solution {
public:
    int findSmallest(vector<int>& arr) {
        sort(arr.begin(), arr.end());

        long long res = 1;

        for (int num : arr) {

            // If current number is greater than res,
            // then res cannot be formed
            if (num > res) {
                break;
            }

            // Extend reachable sum range
            res += num;
        }

        return (int)res;
    }
};