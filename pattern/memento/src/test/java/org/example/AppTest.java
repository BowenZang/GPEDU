package org.example;

import static org.junit.Assert.assertTrue;

import org.example.memonto.ArticleMemento;
import org.example.memonto.DraftsBox;
import org.example.memonto.Editor;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void mementoTest() {
        DraftsBox draftsBox = new DraftsBox();

        Editor editor = new Editor("Spring course!", "Let's study spring!", "211dasgagsasdacacsad.jpeg");
        System.out.println("editor : " + editor);

        ArticleMemento articleMemento = editor.saveMemento();
        draftsBox.addArticleMemento(articleMemento);
        System.out.println("save");

        System.out.println("First edit context start");
        editor.setTitle("MyBatis course");
        editor.setContent("Let's study MyBatis!");
        System.out.println("First edit context end");
        System.out.println("editor : " + editor);

        articleMemento = editor.saveMemento();
        draftsBox.addArticleMemento(articleMemento);
        System.out.println("save");

        System.out.println("Second edit context start");
        editor.setTitle("Kafka course");
        editor.setContent("Let's study Kafka!");
        System.out.println("Second edit context end");
        System.out.println("editor : " + editor);

        System.out.println("First go back start");
        articleMemento = draftsBox.getArticleMemento();
        editor.undoFromMemento(articleMemento);
        System.out.println("First go back end");
        System.out.println("editor : " + editor);

        System.out.println("Second go back start");
        articleMemento = draftsBox.getArticleMemento();
        editor.undoFromMemento(articleMemento);
        System.out.println("Second go back end");
        System.out.println("editor : " + editor);
    }
}
