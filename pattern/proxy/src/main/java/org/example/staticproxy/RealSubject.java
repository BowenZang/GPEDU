package org.example.staticproxy;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-18 15:09:08
 */
public class RealSubject implements ISubject {
    @Override
    public void doSth() {
        System.out.println("I will do sth!!");
    }
}
