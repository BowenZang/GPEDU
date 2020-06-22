package org.example;

import static org.junit.Assert.assertTrue;

import org.example.simple.Facade;
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
    public void simpleFacadeTest() {
        Facade facade = new Facade();
        facade.doA();
        facade.doB();
        facade.doC();
    }
}
