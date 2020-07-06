package org.example;

import static org.junit.Assert.assertTrue;

import org.example.classadapt.AC220;
import org.example.classadapt.DC5V;
import org.example.classadapt.PowerAdapter;
import org.example.interfaceadapt.DC;
import org.example.loginadapt.IPassportForThird;
import org.example.loginadapt.PassportForThirdAdapter;
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
    public void classAdaptTest() {
        DC5V dc5V = new PowerAdapter();
        dc5V.outputDC5V();
    }

    @Test
    public void interfaceAdaptTest() {
        DC5V dc5V1 = new org.example.objectadapt.PowerAdapter(new AC220());
        dc5V1.outputDC5V();
    }

    @Test
    public void objectAdaptTest() {
        DC dc = new org.example.interfaceadapt.PowerAdapter(new AC220());
        dc.output5V();
    }

    @Test
    public void passportTest() {
        PassportForThirdAdapter passportForThird = new PassportForThirdAdapter();
        passportForThird.login("张三", "123456");
        passportForThird.loginForQQ("123412312321");
        passportForThird.loginForWechat("123124151");
    }

    @Test
    public void passport2Test() {
        IPassportForThird passportForThird = new PassportForThirdAdapter();
        passportForThird.loginForQQ("123456");
    }
}
