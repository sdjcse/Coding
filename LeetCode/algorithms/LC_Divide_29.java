package LeetCode.algorithms;

public class LC_Divide_29 {
    public static void main(String[] args) {
        /* System.out.println(
                new LC_Divide_29().divide(
                        -2147483648,
                        2
                )
        ); */


        System.out.println(
                optiDivide(
                        200,4
                )
        );
    }

    public int divide(int dividend, int divisor) {
        long quotient = 0;
        long div = dividend <0 ? new Long(dividend)*-1 : new Long(dividend);
        long divi = divisor < 0 ? new Long(divisor)*-1 : new Long(divisor);
        boolean negative = (divisor < 0 && dividend >0) || (divisor > 0 && dividend <0) ? true : false;
        if(divisor == 1){
            return returner(dividend);
        }else if(divisor == -1){
            return returner(-1 * new Long(dividend));
        }else if(divi > div){
            return 0;
        }
        while(div >= divi){
            div -= divi;
            quotient++;
        }
        quotient = negative ? (quotient*-1) : quotient;
        return returner(quotient);
    }

    public static int optiDivide(int dividend, int divisor){
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }else if(divisor == -1 && dividend == Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        long interDiv = Math.abs((long)dividend);
        long interDivisor = Math.abs((long)divisor);
        int result = 0;
        while(interDiv>=interDivisor){
            int numShift = 0;
            while(interDiv>=(interDivisor<<numShift)){
                numShift++;
            }
            result += 1<<(numShift-1);
            interDiv -= (interDivisor<<(numShift-1));
        }
        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
            return result;
        }
        return -result;
    }

    public int returner(long num){
        return num < Integer.MIN_VALUE  || num > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) num;
    }
}
