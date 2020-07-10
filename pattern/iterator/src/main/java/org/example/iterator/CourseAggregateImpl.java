package org.example.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-08 13:58:38
 */
public class CourseAggregateImpl<T> implements CourseAggregate<T> {

    private List<T> courseList;

    public CourseAggregateImpl() {
        this.courseList = new ArrayList<>();
    }

    @Override
    public void add(T t) {
        this.courseList.add(t);
    }

    @Override
    public void remove(T t) {
        this.courseList.remove(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl<>(courseList);
    }
}
