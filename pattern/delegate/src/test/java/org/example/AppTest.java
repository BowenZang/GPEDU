package org.example;

import static org.junit.Assert.assertTrue;

import org.example.delegate.Boss;
import org.example.delegate.Leader;
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
    public void delegateTest() {
        new Boss().askTask(Leader.class, "cleaner");
        new Boss().askTask(Leader.class, "programmer");
    }
}
