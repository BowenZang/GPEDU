package org.example.staticproxy;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-18 15:09:55
 */
public class SubjectProxy implements ISubject {

    private final RealSubject realSubject;

    public SubjectProxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void doSth() {
        before();
        realSubject.doSth();
        after();
    }

    private void before() {
        System.out.println("I will do sth before");
    }

    private void after() {
        System.out.println("I will do sth after");
    }
}
