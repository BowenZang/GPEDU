package org.example.gp;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-24 10:38:53
 */
public class Node extends AbstractTree {

    public Node(String nodeName) {
        super(nodeName);
    }

    @Override
    public void print() {
        System.out.println(nodeName);
    }
}
