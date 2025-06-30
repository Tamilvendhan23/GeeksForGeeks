class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int low = Arrays.stream(arr).min().getAsInt();
        int high = low + k;
        int answer = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, k, w, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    private boolean isPossible(int[] arr, int k, int w, int target) {
        int n = arr.length;
        int[] increment = new int[n + 1]; // difference array
        long operations = 0;
        int currentAdd = 0;

        for (int i = 0; i < n; i++) {
            currentAdd += increment[i];
            int currentHeight = arr[i] + currentAdd;

            if (currentHeight < target) {
                int need = target - currentHeight;
                operations += need;
                if (operations > k) return false;

                currentAdd += need;
                if (i + w < increment.length) {
                    increment[i + w] -= need;
                }
            }
        }
        return true;
    }
}
