package org.example.lucency;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-23 17:39:20
 */
public abstract class CourseComponent {

    public void addChild(CourseComponent courseComponent) {
        throw new RuntimeException("Do not support opt for add");
    }

    public void rmChild(CourseComponent courseComponent) {
        throw new RuntimeException("Do not support opt for remove");
    }

    public String getName(CourseComponent courseComponent) {
        throw new RuntimeException("Do not support opt for get component name");
    }

    public double getPrice(CourseComponent courseComponent) {
        throw new RuntimeException("Do not support opt for get component price");
    }

    public void print() {
        throw new RuntimeException("Do not support opt for print");
    }
}
