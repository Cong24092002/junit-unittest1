package com.congnguyen.testJUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

public class MathutilTest {

    @Test // khai báo cho JVM biết cần chạy hàm này (như 1 hàm main)
    public void testCaseVeryWell(){
        Assert.assertEquals(1, MathUtil.getFactorial(1));
        Assert.assertEquals(2, MathUtil.getFactorial(2));
        Assert.assertEquals(6, MathUtil.getFactorial(3));
        Assert.assertEquals(24, MathUtil.getFactorial(4));
        Assert.assertEquals(120, MathUtil.getFactorial(5));
    }

    @Test
    public void testCaseWithException(){
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {MathUtil.getFactorial(-5);
                                                                                    }

        );
        String msActual = ex.getMessage();
        String expected = "Bug";
        Assertions.assertTrue(msActual.contains(expected));
    }



    // test kểu tham số hóa

    public static Integer[][] initData(){
        return new Integer[][] {{1,1}, {2,2},{3,6},{4,24},{5,120},{6,720}};
    }

    @ParameterizedTest
    @MethodSource("initData")
    public void testParamsVerryWell(int input, int actual){
            Assertions.assertEquals(actual, MathUtil.getFactorial(input));
    }
}
