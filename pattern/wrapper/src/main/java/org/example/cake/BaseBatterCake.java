package org.example.cake;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-22 20:29:46
 */
public class BaseBatterCake extends BatterCake{

    @Override
    public String getMsg() {
        return "BatterCake";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
