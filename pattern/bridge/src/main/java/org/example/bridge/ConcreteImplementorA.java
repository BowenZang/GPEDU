package org.example.bridge;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 20:02:45
 */
public class ConcreteImplementorA implements IImplementor {
    @Override
    public void operationImpl() {
        System.out.println("I'm concreteImplementor A");
    }
}
