class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        
        ArrayList<Integer> res= new ArrayList<>();
       
       res.add(arr[arr.length-1]);
        int pr= arr[arr.length-1];
        
        for(int i=arr.length-2;i>=0;i--){
             
            if (pr<=arr[i]){
                
                res.add(arr[i]);
                pr=arr[i];
                
            }
            
        }
        Collections.reverse(res);
 return res;
    }
}
