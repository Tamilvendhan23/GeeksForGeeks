//{ Driver Code Starts
// Driver code
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution {
public:
    // Function to find the latest available slot
    int findParent(int slot, vector<int> &parent) {
        if (parent[slot] == slot) return slot;
        return parent[slot] = findParent(parent[slot], parent);
    }

    vector<int> jobSequencing(vector<int> &deadline, vector<int> &profit) {
        int n = deadline.size();
        vector<pair<int, int>> jobs;

        // Store jobs as {profit, deadline} pairs
        for (int i = 0; i < n; i++) {
            jobs.push_back({profit[i], deadline[i]});
        }

        // Sort jobs by profit in descending order
        sort(jobs.rbegin(), jobs.rend());

        // Find the maximum deadline
        int maxDeadline = *max_element(deadline.begin(), deadline.end());

        // Parent array for Disjoint Set
        vector<int> parent(maxDeadline + 1);
        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        int maxProfit = 0, jobsDone = 0;

        // Schedule the jobs
        for (auto &job : jobs) {
            int profit = job.first;
            int dead = job.second;

            // Find the latest available slot before or on the deadline
            int availableSlot = findParent(dead, parent);

            // If a valid slot is found
            if (availableSlot > 0) {
                jobsDone++;
                maxProfit += profit;
                // Mark the previous slot as the new root
                parent[availableSlot] = findParent(availableSlot - 1, parent);
            }
        }

        return {jobsDone, maxProfit};
    }
};




//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> deadlines, profits;
        string temp;
        getline(cin, temp);
        int x;
        istringstream ss1(temp);
        while (ss1 >> x)
            deadlines.push_back(x);

        getline(cin, temp);
        istringstream ss2(temp);
        while (ss2 >> x)
            profits.push_back(x);

        Solution obj;
        vector<int> ans = obj.jobSequencing(deadlines, profits);
        cout << ans[0] << " " << ans[1] << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends