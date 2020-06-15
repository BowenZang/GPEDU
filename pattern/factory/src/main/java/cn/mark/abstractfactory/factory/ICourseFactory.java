package cn.mark.abstractfactory.factory;

import cn.mark.abstractfactory.INote;
import cn.mark.abstractfactory.IVideo;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-15 17:00:17
 */
public abstract class ICourseFactory {
    public void init() {
        System.out.println("Initializes the underlying data!");
    }

    public abstract INote createNote();

    public abstract IVideo createVideo();
}
