package org.example;

import static org.junit.Assert.assertTrue;

import org.example.template.JavaCourse;
import org.example.template.PythonCourse;
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
    public void templateTest() {
        JavaCourse javaCourse = new JavaCourse();
        javaCourse.setNeedCheckHomework(true);
        javaCourse.createCourse();

        PythonCourse pythonCourse = new PythonCourse();
        pythonCourse.createCourse();
    }
}
