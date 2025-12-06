class Solution {
    public static int largest(int[] arr) {
        // code here
        int res=arr[0];
        for (int i=1;i<arr.length;i++){
            if( res<arr[i]){
                res=arr[i];
            }
        }
        return res;
        
    }
}
