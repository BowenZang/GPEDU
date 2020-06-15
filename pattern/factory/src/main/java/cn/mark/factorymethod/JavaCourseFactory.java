package cn.mark.factorymethod;

import cn.mark.simplefacotry.ICourse;
import cn.mark.simplefacotry.JavaCourse;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-15 16:54:27
 */
public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
