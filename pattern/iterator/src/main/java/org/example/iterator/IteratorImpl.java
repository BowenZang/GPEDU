package org.example.iterator;

import java.util.List;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-08 11:51:23
 */
public class IteratorImpl<E> implements Iterator<E> {

    private List<E> list;
    private int cursor = 0;
    private E element;

    public IteratorImpl(List<E> list) {
        this.list = list;
    }

    @Override
    public E next() {
        System.out.println("当前位置 ：" + cursor);
        element = list.get(cursor);
        cursor++;
        return element;
    }

    @Override
    public boolean hasNext() {
        return cursor <= list.size() - 1;
    }
}
