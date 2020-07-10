package org.example.iterator;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-08 11:50:28
 */
public interface CourseAggregate<T> {

    void add(T t);

    void remove(T t);

    Iterator<T> iterator();

}
