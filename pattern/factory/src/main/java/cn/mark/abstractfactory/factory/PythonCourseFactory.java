package cn.mark.abstractfactory.factory;

import cn.mark.abstractfactory.*;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-15 17:39:50
 */
public class PythonCourseFactory extends ICourseFactory {

    @Override
    public INote createNote() {
        super.init();
        return new PythonNote();
    }

    @Override
    public IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }
}
