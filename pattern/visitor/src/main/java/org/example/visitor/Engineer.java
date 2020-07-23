package org.example.visitor;

import java.util.Random;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 11:16:18
 */
public class Engineer extends Employee{

    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }

}
