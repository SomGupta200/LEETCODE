class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character , Integer> mp = new HashMap<>();
        StringBuilder sb = new StringBuilder("");

        for(int i  = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            mp.put(ch , mp.getOrDefault(ch , 0) +1);
        }
        for(int i = 0 ; i < order.length() ; i++){
            char ch = order.charAt(i);
            if(mp.containsKey(ch)){
                int val = mp.get(ch);
                while(val > 0){
                    sb.append(ch);
                    val--;
                }
                mp.remove(ch);
            }
        }
        for(Character ch : mp.keySet()){
            int val = mp.get(ch);
            while(val > 0){
                sb.append(ch);
                val --;
            }
        }
        return sb.toString();
    }
}