package org.example.mkproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-18 21:42:53
 */
public class MKClassLoader extends ClassLoader {

    private final File classPathFile;

    public MKClassLoader() {
        String classPath = MKClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    protected Class<?> findClass(String name) {
        String className = MKClassLoader.class.getPackage().getName() + "." + name;

        File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
        if (classFile.exists()) {
            FileInputStream in = null;
            ByteArrayOutputStream out = null;

            try {
                in = new FileInputStream(classFile);
                out = new ByteArrayOutputStream();
                byte[] buff = new byte[1024];
                int len;
                while ((len = in.read(buff)) != -1) {
                    out.write(buff, 0, len);
                }
                return defineClass(className, out.toByteArray(), 0, out.size());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != in) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (null != out) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}
