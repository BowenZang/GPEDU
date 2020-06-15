package cn.mark.factorymethod;

import cn.mark.simplefacotry.ICourse;
import cn.mark.simplefacotry.PythonCourse;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-15 16:55:03
 */
public class PythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
