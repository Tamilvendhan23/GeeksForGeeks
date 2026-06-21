class Solution {
    public String chooseSwap(String s) {
        int[] first = new int[26];

        for (int i = 0; i < 26; i++)
            first[i] = -1;

        // Store first occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            if (first[s.charAt(i) - 'a'] == -1)
                first[s.charAt(i) - 'a'] = i;
        }

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i] - 'a';

            // Find a smaller character occurring later
            for (int j = 0; j < curr; j++) {
                if (first[j] > i) {
                    char c1 = arr[i];
                    char c2 = (char) (j + 'a');

                    // Swap all occurrences
                    for (int k = 0; k < arr.length; k++) {
                        if (arr[k] == c1)
                            arr[k] = c2;
                        else if (arr[k] == c2)
                            arr[k] = c1;
                    }

                    return new String(arr);
                }
            }
        }

        return s;
    }
}