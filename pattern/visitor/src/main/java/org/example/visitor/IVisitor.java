package org.example.visitor;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 11:15:42
 */
public interface IVisitor {

    void visit(Engineer engineer);

    void visit(Manager manager);
}
