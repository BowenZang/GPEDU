package org.example.builder;

import org.example.pojo.Course;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-18 10:56:10
 */
public class CourseBuilder implements IBuilder<Course> {

    private final Course course = new Course();

    public CourseBuilder addName(String name) {
        course.setName(name);
        return this;
    }

    public CourseBuilder addVideo(String video) {
        course.setVideo(video);
        return this;
    }

    public CourseBuilder addNote(String note) {
        course.setNote(note);
        return this;
    }

    @Override
    public Course build() {
        return course;
    }
}
