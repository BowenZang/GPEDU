package cn.mark.simplefacotry;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-15 11:51:59
 */
public class CourseFactory {

    public static ICourse createCourse(String name) {
        if (null == name) {
            return null;
        }
        switch (name) {
            case "java":
                return new JavaCourse();
            case "python":
                return new PythonCourse();
            default:
                return null;
        }
    }

    public static ICourse createCourseByClassName(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (null == className) {
            return null;
        }
        Class<?> clazz = Class.forName(className);
        return (ICourse) clazz.newInstance();
    }

    public static ICourse createCourseByClass(Class<? extends ICourse> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

}
