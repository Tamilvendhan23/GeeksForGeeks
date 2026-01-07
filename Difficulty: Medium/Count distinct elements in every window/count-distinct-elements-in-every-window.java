

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0 || k == 0) {
            return result;
        }

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Build the first window
        for (int i = 0; i < k; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        result.add(freq.size());

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            // Element going out of the window
            int outgoing = arr[i - k];
            int count = freq.get(outgoing);
            if (count == 1) {
                freq.remove(outgoing);
            } else {
                freq.put(outgoing, count - 1);
            }

            // Element coming into the window
            int incoming = arr[i];
            freq.put(incoming, freq.getOrDefault(incoming, 0) + 1);

            // Current distinct count
            result.add(freq.size());
        }

        return result;
    }
}
