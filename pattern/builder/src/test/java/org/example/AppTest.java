package org.example;

import static org.junit.Assert.assertTrue;

import org.example.builder.CourseBuilder;
import org.example.builder.IBuilder;
import org.example.pojo.Course;
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
    public void buildCourse() {
        Course course = new CourseBuilder()
                .addName("Mark")
                .addVideo("javaVideo")
                .addNote("javaNote").build();

        System.out.println(course);
    }
}
