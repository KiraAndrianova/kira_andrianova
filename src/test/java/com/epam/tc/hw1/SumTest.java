package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest extends BaseTest {

    @DataProvider
    public static Object[][] sumCorrectDataDouble() {
        return new Object[][]{
                {1.0, 2.0, 3.0},
                {0.0, 0.0, 0.0},
                {9.9, 1.1, 11.0},
                {9999999.0, 9999999.0, 19999998.0},
                {-7.0, 3.0, -4.0},
                {-99.0, -1111111111.0, -1111111210.0},
                {1.999, -1.999, 0}
        };
    }

    @DataProvider
    public static Object[][] sumCorrectDataLong() {
        return new Object[][]{
                {1, 2, 3},
                {0, 0, 0},
                {9, 1, 10},
                {-7, 3, -4},
                {-99, -1111111111, -1111111210},
                {1999, -1999, 0}
        };
    }


    @Test(dataProvider = "sumCorrectDataDouble")
    public void sumTestDouble(double a, double b, double res) {
        double act = calculator.sum(a, b);

        assertThat(act).as("Calculation was wrong")
                .isEqualTo(res);
    }

    @Test(dataProvider = "sumCorrectDataLong")
    public void sumTestLong(long a, long b, long res) {
        long act = calculator.sum(a, b);

        assertThat(act).as("Calculation was wrong")
                .isEqualTo(res);

    }

}
