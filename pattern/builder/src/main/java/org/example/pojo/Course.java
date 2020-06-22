package org.example.pojo;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-18 10:57:34
 */
public class Course {
    private String name;
    private String video;
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", video='" + video + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
