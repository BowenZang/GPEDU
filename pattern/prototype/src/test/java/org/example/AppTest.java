package org.example;

import static org.junit.Assert.assertTrue;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public void UserClone() {
        User user = new User();
        user.setUserId("123");
        user.setUsername("mark");
        user.setMobilePhone("13888888888");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("hobbies1");
        hobbies.add("hobbies2");
        hobbies.add("hobbies3");
        user.setHobbies(hobbies);
        User user1 = user.clone();
        System.out.println(user);
        System.out.println(user1);

        user1.getHobbies().add("hobbies4");
        System.out.println(user);
        System.out.println(user1);

        try {
            User user2 = user.deepClone();
            System.out.println(user);
            System.out.println(user2);

            user2.getHobbies().add("hobbies5");
            System.out.println(user);
            System.out.println(user2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void userCloneByJson() {
        User user = new User();
        user.setUserId("123");
        user.setUsername("mark");
        user.setMobilePhone("13888888888");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("hobbies1");
        hobbies.add("hobbies2");
        hobbies.add("hobbies3");
        user.setHobbies(hobbies);

        User user2 = JSON.parseObject(JSON.toJSONString(user), User.class);
        System.out.println(user);
        System.out.println(user2);

        user2.getHobbies().add("hobbies4");
        System.out.println(user);
        System.out.println(user2);
    }
}
