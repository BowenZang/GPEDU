package org.example.visitor;

import java.util.Random;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 11:13:54
 */
public abstract class Employee {

    public String name;
    public int kpi;

    public Employee(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    /**
     * 核心方法，接受访问者的访问
     * @param visitor
     */
    public abstract void accept(IVisitor visitor);
}
