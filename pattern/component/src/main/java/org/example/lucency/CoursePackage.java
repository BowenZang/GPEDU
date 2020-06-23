package org.example.lucency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-23 17:45:07
 */
public class CoursePackage extends CourseComponent {

    private final List<CourseComponent> courseComponentList = new ArrayList<>();
    private final String name;
    private final Integer level;

    public CoursePackage(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void addChild(CourseComponent courseComponent) {
        courseComponentList.add(courseComponent);
    }

    @Override
    public void rmChild(CourseComponent courseComponent) {
        courseComponentList.remove(courseComponent);
    }

    @Override
    public String getName(CourseComponent courseComponent) {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(this.name);

        for (CourseComponent each : courseComponentList) {
            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    System.out.print(" ");
                }
                for (int i = 0; i < this.level; i++) {
                    // 每一行开始打印一个+号
                    if (0 == i) {
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            each.print();
        }
    }
}
