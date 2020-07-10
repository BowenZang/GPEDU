package org.example;

import static org.junit.Assert.assertTrue;

import org.example.iterator.Course;
import org.example.iterator.CourseAggregate;
import org.example.iterator.CourseAggregateImpl;
import org.example.iterator.Iterator;
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
    public void iteratorTest() {
        Course java = new Course("Java");
        Course python = new Course("Python");
        Course bigData = new Course("BigData");
        CourseAggregate<Course> courseAggregate = new CourseAggregateImpl<>();
        courseAggregate.add(java);
        courseAggregate.add(python);
        courseAggregate.add(bigData);

        System.out.println("--- Course list ---");
        printCourse(courseAggregate);

        System.out.println("---rm python course---");
        courseAggregate.remove(python);
        printCourse(courseAggregate);
    }

    private void printCourse(CourseAggregate<Course> courseAggregate) {
        Iterator<Course> iterator = courseAggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
