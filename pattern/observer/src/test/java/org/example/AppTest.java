package org.example;

import static org.junit.Assert.assertTrue;

import com.google.common.eventbus.EventBus;
import org.example.observer.gp.GPer;
import org.example.observer.gp.Question;
import org.example.observer.gp.Teacher;
import org.example.observer.guava.GuavaEvent;
import org.example.observer.swing.EventListener;
import org.example.observer.swing.Mouse;
import org.example.observer.swing.MouseEventListener;
import org.example.observer.swing.MouseEventTypeEnum;
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
    public void observerTest() {
        GPer gPer = GPer.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher mic = new Teacher("Mic");

        gPer.addObserver(tom);
        gPer.addObserver(mic);

        Question question = new Question();
        question.setUsername("mark");
        question.setContent("观察者模式是什么？");

        gPer.publishQuestion(question);
    }

    @Test
    public void guavaTest() {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("Tom");
    }

    @Test
    public void mouseTest() {
        EventListener listener = new MouseEventListener();

        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventTypeEnum.ON_CLICK, listener);
        mouse.addListener(MouseEventTypeEnum.ON_DOUBLE_CLICK, listener);
        mouse.addListener(MouseEventTypeEnum.ON_UP, listener);
        mouse.addListener(MouseEventTypeEnum.ON_DOWN, listener);
        mouse.addListener(MouseEventTypeEnum.ON_OVER, listener);
        mouse.addListener(MouseEventTypeEnum.ON_WHEEL, listener);
        mouse.addListener(MouseEventTypeEnum.ON_MOVE, listener);
        mouse.addListener(MouseEventTypeEnum.ON_BLUR, listener);
        mouse.addListener(MouseEventTypeEnum.ON_FOCUS, listener);

        mouse.click();
        mouse.doubleClick();
        mouse.up();
        mouse.down();
        mouse.over();
        mouse.wheel();
        mouse.move();
        mouse.blur();
        mouse.focus();
    }
}
