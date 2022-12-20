package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubTest extends BaseTest {

    @DataProvider
    public static Object[][] subCorrectData() {
        return new Object[][] {
                {-1.0, 2.0, -3.0},
                {-1.0, -2.0, 1.0}
        };
    }

    @Test(dataProvider = "subCorrectData")
    public void subTest(double a, double b, double res) {
        double act = calculator.sub(a, b);

        assertThat(act).as("Calculation was wrong")
                .isEqualTo(res);
    }

}
