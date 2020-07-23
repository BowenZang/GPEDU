package org.example;

import static org.junit.Assert.assertTrue;

import org.example.mediator.ChatRoom;
import org.example.mediator.User;
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
    public void mediatorTest() {
        ChatRoom chatRoom = new ChatRoom();

        User user1 = new User("Tom", chatRoom);
        User user2 = new User("Marry", chatRoom);
        user1.sendMessage("Hi Marry! I'm Tom!");
        user2.sendMessage("Hi Tom! I'm Marry!");
    }
}
