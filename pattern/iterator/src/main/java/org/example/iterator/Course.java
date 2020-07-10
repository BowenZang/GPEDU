package org.example.iterator;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-08 11:48:22
 */
public class Course {

    private String name;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
