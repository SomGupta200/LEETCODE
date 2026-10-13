class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length , n2 = arr2.length;
        int[] ans = new int[n1];
        HashMap<Integer , Integer> mp = new HashMap<>();
        for(int i :arr1){
            mp.put(i , mp.getOrDefault(i , 0) +1);
        }
        int k = 0;
        for(int i = 0 ; i < n2 ; i++){
            int val = mp.get(arr2[i]);  
            while(val > 0){
                ans[k] = arr2[i];
                k++;
                val--;
            }
            mp.put(arr2[i] , 0);
        }
        Arrays.sort(arr1);
        for(int i : arr1){
            if(mp.get(i) > 0){
                ans[k] = i;
                k++;
            }
        }
        return ans;
    }
}