class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer , Integer> nge = new HashMap<>();

        for(int i = nums2.length-1 ; i >=0 ; i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            if(!st.isEmpty() && st.peek() > nums2[i]){
                nge.put(nums2[i] , st.peek());
            }else {
                nge.put(nums2[i] , -1);
            }
            st.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for(int i= 0 ; i < nums1.length ; i++){
            ans[i] = nge.get(nums1[i]);
        }
        return ans;
    }
}