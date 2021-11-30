class Solution {
    public int divide(int dividend, int divisor) {
        int ret = 0;
        
        // 제수(divisor)와 피제수(dividend)의 부호가 같으면 몫은 가감되며, 다르면 차감된다.
        int add = 0;
        add += (divisor <0)?-1:1;
        add += (dividend<0)?-1:1;
        add  = (add==0)?-1:1;
        
        // 피제수가 int 최대값일경우를 대비하여 형변환을 한다.
        // 몫을 구하기 위해 제수와 피제수를 양수로 전환한다.
        long divisor2;
        long dividend2;
        divisor2  = Math.abs(divisor);
        dividend2 = Math.abs(dividend);
        
        // Overflow 예외 처리
        if(dividend2 == Integer.MIN_VALUE) {
            System.out.println("check");
            dividend2  = Integer.MAX_VALUE;
            dividend2 += 1;
            if (divisor2 == 1 && add == 1) {
                return Integer.MAX_VALUE;
            }
        }
        System.out.println(dividend2);
        while(dividend2 >= divisor2) {
            dividend2 -= divisor2;
            ret += add;
        }
        return ret;
    }
}