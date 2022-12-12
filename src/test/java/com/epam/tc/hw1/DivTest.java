package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivTest {
    Calculator calculator;

    @BeforeMethod
    public void before() {
        calculator = new Calculator();
    }


    @DataProvider
    public static Object[][] divCorrectDataDouble() {
        return new Object[][] {
                {1.5, 1.1, 1.3636363636363635},
                {0.0, 100.5, 0.0}
        };
    }

    @Test(dataProvider = "divCorrectDataDouble")
    public void divTest(double a, double b, double res) {
        var act = calculator.div(a,b);

        assertThat(act).as("Calculation was wrong")
                .isEqualTo(res);
    }

    @AfterMethod
    public void after() {
        calculator = null;
    }
}
