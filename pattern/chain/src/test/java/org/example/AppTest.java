package org.example;

import static org.junit.Assert.assertTrue;

import org.example.chain.*;
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
    public void chainTest() {
        new MemberService().login("zhangsan", "123456");

    }
}
