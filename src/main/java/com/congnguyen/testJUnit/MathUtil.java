package com.congnguyen.testJUnit;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class MathUtil {

   public static long getFactorial(int n){
       if(n<0 || n>20) {
           throw new IllegalArgumentException("Bug");
       }
       if(n==1 || n==0) return 1;
       long res = 1;
       for(int i=2;i<=n;i++){
           res *= i;
       }
       return res;
   }
}
