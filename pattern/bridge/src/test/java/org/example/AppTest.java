package org.example;

import static org.junit.Assert.assertTrue;

import org.example.bridge.Abstraction;
import org.example.bridge.ConcreteImplementorA;
import org.example.bridge.IImplementor;
import org.example.bridge.RefinedAbstraction;
import org.example.message.AbstractMessage;
import org.example.message.EmailMessage;
import org.example.message.IMessage;
import org.example.message.UrgencyMessage;
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
    public void bridgeTest() {
        // 实现化角色
        IImplementor implementor = new ConcreteImplementorA();
        // 抽象化角色
        Abstraction abstraction = new RefinedAbstraction(implementor);
        // 执行操作
        abstraction.operation();
    }

    @Test
    public void sendBridgeTest() {
        IMessage message = new EmailMessage();
        AbstractMessage abstractMessage = new UrgencyMessage(message);
        abstractMessage.sendMessage("I need much money!", "mark!");
    }
}
