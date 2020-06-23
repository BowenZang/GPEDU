package org.example.lucency;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-23 17:41:44
 */
public class Course extends CourseComponent {

    private final String name;

    private final double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CourseComponent courseComponent) {
        return this.name;
    }

    @Override
    public double getPrice(CourseComponent courseComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println(name + "(¥" + price + "元)");
    }
}
