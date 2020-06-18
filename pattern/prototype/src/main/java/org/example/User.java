package org.example;

import lombok.Data;

import java.io.*;
import java.util.List;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-17 20:21:38
 */
@Data
public class User implements Cloneable, Serializable {

    private String userId;
    private String username;
    private String mobilePhone;
    private List<String> hobbies;

    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (User) ois.readObject();
    }
}
