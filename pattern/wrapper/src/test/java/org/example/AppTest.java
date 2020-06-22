package org.example;

import static org.junit.Assert.assertTrue;

import com.alibaba.fastjson.JSON;
import org.example.cake.BaseBatterCake;
import org.example.cake.BatterCake;
import org.example.cake.EggWrapper;
import org.example.cake.SausageWrapper;
import org.example.gp.*;
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
    public void baseCakeWrapperTest() {
        BatterCake batterCake = new BaseBatterCake();
        batterCake = new EggWrapper(batterCake);
        batterCake = new EggWrapper(batterCake);

        batterCake = new SausageWrapper(batterCake);
        batterCake = new SausageWrapper(batterCake);

        System.out.println(batterCake.getMsg());
        System.out.println(batterCake.getPrice());
    }

    @Test
    public void gpGuiderTest() {
        Guider baseGuider = new BaseGuider();
        baseGuider = new AskGuider(baseGuider);
        baseGuider = new ContextGuider(baseGuider);
        baseGuider = new ClassicalGuider(baseGuider);
        baseGuider = new BubblingGuider(baseGuider);
        baseGuider = new MallGuider(baseGuider);
        System.out.println("Base user guider : " + baseGuider.getGuiders());

        Guider vipGuider = new BaseGuider();
        vipGuider = new AskGuider(baseGuider);
        vipGuider = new ContextGuider(baseGuider);
        vipGuider = new ClassicalGuider(baseGuider);
        vipGuider = new BubblingGuider(baseGuider);
        vipGuider = new MallGuider(baseGuider);
        vipGuider = new HomeworkGuider(vipGuider);
        vipGuider = new TextGuider(vipGuider);
        vipGuider = new GrowWallGuider(vipGuider);

        System.out.println("Vip user guider : " + vipGuider.getGuiders());
    }
}
