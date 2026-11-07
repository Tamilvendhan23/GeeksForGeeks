class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        ArrayList<String> ans = new ArrayList<>();
        HashSet<String> reserved = new HashSet<>();
        HashSet<String> assigned = new HashSet<>();

        // Reserve every username that appears anywhere in the input
        for (String name : arr) {
            reserved.add(name);
        }

        for (String name : arr) {
            if (assigned.add(name)) {
                // First occurrence of this exact username
                ans.add(name);
            } else {
                // Find smallest positive suffix not reserved/assigned
                int suffix = 1;
                while (true) {
                    String candidate = name + suffix;

                    if (!reserved.contains(candidate) && assigned.add(candidate)) {
                        ans.add(candidate);
                        break;
                    }
                    suffix++;
                }
            }
        }

        return ans;
    }
}