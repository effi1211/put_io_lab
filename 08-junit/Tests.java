-----------------------------CalculatorTest.java-----------------------------

package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calc = null;
    /*
    BeforeAll nie zadziala, poniewaz wymaga metody statycznej.
    */
    @BeforeEach
    public void SetUp(){
        calc = new Calculator();
    }

    @Test
    public void test_add_dif() {
        int actual = calc.add(2, 3);
        int expected = 5;

        assertEquals(expected, actual, "Result is not correct.");
    }

    @Test
    public void test_add_equ() {
        int actual = calc.add(2, 2);
        int expected = 4;

        assertEquals(expected, actual, "Result is not correct.");
    }

    @Test
    public void test_mult_dif() {
        int actual = calc.multiply(2, 3);
        int expected = 6;

        assertEquals(expected, actual, "Result is not correct.");
    }

    @Test
    public void test_mult_equ() {
        int actual = calc.multiply(2, 0);
        int expected = 0;

        assertEquals(expected, actual, "Result is not correct.");
    }

    @Test
    public void test_add_ill() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.addPositiveNumbers(-1, 2);
        });
    }

}

-----------------------------FailureOnErrorTest.java-----------------------------
 package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FailureOnErrorTest {

    @Test //failure
    public void FailureOrErrorTest1() {
        assertEquals(-2,5);
    }

    @Test //error
    public void FailureOrErrorTest2() {
        throw new IllegalArgumentException();
    }

}

-----------------------------CalculatorTest.java-----------------------------
package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import put.io.testing.junit.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    //5.1. whitebox
    //5.2. 4
    private Audiobook audiobook;
    private AudiobookPriceCalculator calculator;
    @BeforeEach
    public void SetUp(){
        audiobook =  new Audiobook("test", 100);
        calculator = new AudiobookPriceCalculator();
    }

    @Test
    void calculateStandard() {
        Customer customer = new Customer("Ewa", Customer.LoyaltyLevel.STANDARD, false);
        assertEquals(100, calculator.calculate(customer, audiobook));
    }

    @Test
    void calculateSilver() {
        Customer customer = new Customer("Ewa", Customer.LoyaltyLevel.SILVER, false);
        assertEquals(90, calculator.calculate(customer, audiobook));
    }

    @Test
    void calculateGold() {
        Customer customer = new Customer("Ewa", Customer.LoyaltyLevel.GOLD, false);
        assertEquals(80, calculator.calculate(customer, audiobook));
    }

    @Test
    void calculateSubscriber() {
        Customer customer = new Customer("Ewa", Customer.LoyaltyLevel.STANDARD, true);
        assertEquals(0, calculator.calculate(customer, audiobook));
    }
}
