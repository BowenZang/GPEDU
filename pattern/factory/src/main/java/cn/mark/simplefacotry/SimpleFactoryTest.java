package cn.mark.simplefacotry;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-15 11:50:34
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        // 1
        ICourse course1 = new JavaCourse();
        course1.record();
        ICourse course2 = new PythonCourse();
        course2.record();

        // 2
        System.out.println("createCourse");
        CourseFactory.createCourse("java").record();
        CourseFactory.createCourse("python").record();

        // 3
        try {
            System.out.println("createCourseByClassName");
            CourseFactory.createCourseByClassName("cn.mark.simplefacotry.JavaCourse").record();
            CourseFactory.createCourseByClassName("cn.mark.simplefacotry.PythonCourse").record();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        // 4
        try {
            System.out.println("createCourseByClass");
            CourseFactory.createCourseByClass(JavaCourse.class).record();
            CourseFactory.createCourseByClass(PythonCourse.class).record();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

}
