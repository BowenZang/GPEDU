package org.example.biz;

import org.example.api.IHelloService;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-05-23 18:15:46
 */
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String name) {
        return "Hello! " + name;
    }

}
