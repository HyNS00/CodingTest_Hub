class Solution {
    public int solution(int chicken) {
        int coupon = chicken;
        int service = 0;
        while(coupon >= 10){
            int newService = coupon/10;
            service += newService;
            coupon = coupon % 10 + newService;
        }
        return service;
    }
}