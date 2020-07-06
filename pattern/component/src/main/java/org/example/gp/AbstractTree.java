package org.example.gp;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-24 10:34:44
 */
public abstract class AbstractTree {

    protected String nodeName;

    public AbstractTree(String nodeName) {
        this.nodeName = nodeName;
    }

    public abstract void print();

}
