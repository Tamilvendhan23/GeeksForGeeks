class Solution {
public int dominantPairs(int[] arr) {
int n = arr.length;
int mid = n / 2;
int[] left = Arrays.copyOfRange(arr, 0, mid);
int[] right = Arrays.copyOfRange(arr, mid, n);
Arrays.sort(left);
Arrays.sort(right);

int j = 0;
int count = 0;
// For each i in left (ascending), advance j in right while left[i] >= 5 * right[j]
for (int i = 0; i < left.length; i++) {
while (j < right.length && (long)left[i] >= 5L * right[j]) {
j++;
}
// j is number of rights that satisfy arr[i] >= 5 * arr[j]
count += j;
}
return count;
}
}