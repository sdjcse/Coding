package com.hackerearth.problems.decClash;

    import java.math.BigInteger;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

/**
 * Created by sdj on 12/13/16.
 */
public class GCDString {
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
        int t = n.nextInt();
        List<String> arr = new ArrayList<>();
        while(t>0){
            arr.add(convInt(new BigInteger(modGcd(new BigInteger(n.next()),new BigInteger(n.next())),2)));
            t--;
        }
        for(String s:arr){
            System.out.println(s);
        }
    }

    static public String convInt(BigInteger a){
        return a.remainder(new BigInteger("1000000007")).toString();
    }

    static public String modGcd(BigInteger a, BigInteger b){
        BigInteger zeroB = new BigInteger("0");
        if(a.equals(zeroB)){
            return b.toString();
        }else if(b.equals(zeroB)){
            return a.toString();
        }
        if(b.compareTo(a)>0){
            a = a.multiply(b);
            b = a.divide(b);
            a = a.divide(b);
        }
        Integer gcdStr = 0;
        StringBuffer finStr = null;
        if(a.mod(b)==BigInteger.ZERO){
            finStr = new StringBuffer(Integer.toBinaryString((int) Math.pow(2,a.subtract(new BigInteger("1")).longValue())));
        }else{
             finStr= new StringBuffer(modGcd(b,a.mod(b)));
             int count = 0;
             while(finStr.length()<=a.longValue()){
                 finStr.append(finStr);
             }
             finStr =  new StringBuffer(finStr.substring(0,a.intValue()));
        }
        return finStr.toString();
    }
    // Send in a format where a>b
    static public int gcd(int a,int b){
        int gcd = a==0 && b!=0 ? b : (a!=0 && b==0) ? a : 0;
        if(a==0 || b==0){
            return gcd;
        }
        if(b>a){
            a = a*b;
            b = a/b;
            a = a/b;
        }
        gcd = (a%b==0) ? gcd(a/b,0):gcd(b,a%b);
        return gcd;
    }
}
