package org.example.visitor;

import java.util.Random;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 11:17:29
 */
public class Manager extends Employee {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public int getProducts() {
        return new Random().nextInt(10);
    }
}
