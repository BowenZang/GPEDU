package org.example.memonto;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-21 09:14:01
 */
public class Editor {

    private String title;
    private String content;
    private String imgs;

    public Editor(String title, String content, String imgs) {
        this.title = title;
        this.content = content;
        this.imgs = imgs;
    }

    public ArticleMemento saveMemento() {
        return new ArticleMemento(this.title, this.content, this.imgs);
    }

    public void undoFromMemento(ArticleMemento memento) {
        this.title = memento.getTitle();
        this.content = memento.getContent();
        this.imgs = memento.getImgs();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    @Override
    public String toString() {
        return "Editor{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgs='" + imgs + '\'' +
                '}';
    }
}
