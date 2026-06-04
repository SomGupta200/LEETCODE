class Solution {
    int calcSquare(int n){
        int sum =  0;
        while(n!=0){
         int rem = n % 10;
         sum += rem * rem;
         n/=10;
        }
        return sum;
    }
    public boolean isHappy(int n){
        HashSet<Integer> unique = new HashSet<>();
        while(n!=1){
            if(unique.contains(n)) return false;
            unique.add(n);
            n = calcSquare(n);
        }
        return true;
    }
}