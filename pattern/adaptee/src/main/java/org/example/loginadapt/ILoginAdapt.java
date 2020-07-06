package org.example.loginadapt;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 19:15:06
 */
public interface ILoginAdapt {

    <T extends ILoginAdapt> ResultMsg<?> login(String id, T adapter);

    boolean isClose();
}
