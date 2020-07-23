package org.example;

import static org.junit.Assert.assertTrue;

import org.example.interpreter.Calculator;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void InterpretTest() {
        System.out.println("result : " + new Calculator("1 + 2").calculate());
        System.out.println("result : " + new Calculator("1 - 2").calculate());
        System.out.println("result : " + new Calculator("1 * 2").calculate());
        System.out.println("result : " + new Calculator("1 / 2").calculate());
        System.out.println("result : " + new Calculator("100 + 200 - 150 * 3 / 2").calculate());

    }
}
