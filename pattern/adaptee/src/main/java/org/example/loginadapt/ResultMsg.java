package org.example.loginadapt;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 15:50:46
 */
public class ResultMsg<T> {

    private int code;
    private String msg;
    private T t;

    public ResultMsg(int code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.t = t;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", t=" + t +
                '}';
    }
}
