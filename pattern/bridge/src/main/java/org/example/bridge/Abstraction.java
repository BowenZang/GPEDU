package org.example.bridge;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 20:01:46
 */
public abstract class Abstraction {

    protected IImplementor implementor;

    public Abstraction(IImplementor implementor) {
        this.implementor = implementor;
    }

    public void operation() {
        this.implementor.operationImpl();
    }
}
