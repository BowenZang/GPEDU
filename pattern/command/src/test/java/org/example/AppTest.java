package org.example;

import static org.junit.Assert.assertTrue;

import org.example.command.Controller;
import org.example.command.GPlayer;
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
    public void commandTest() {
        GPlayer gPlayer = new GPlayer();
        Controller controller = new Controller();
        controller.execute(gPlayer::play);


        controller.addAction(gPlayer::speed);
        controller.addAction(gPlayer::stop);
        controller.addAction(gPlayer::pause);
        controller.executes();
    }
}
