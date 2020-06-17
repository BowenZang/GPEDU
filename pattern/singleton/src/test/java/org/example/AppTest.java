package org.example;

import static org.junit.Assert.assertTrue;

import org.example.hungry.ContainerSingleton;
import org.example.hungry.EnumSingleton;
import org.example.hungry.SerializableHungrySingleton;
import org.example.lazy.LazyCheckSingleton;
import org.example.lazy.LazyDoubleCheckSingleton;
import org.example.lazy.LazyInnerSingleton;
import org.example.lazy.LazySimpleSingleton;
import org.example.threadLocal.ThreadLocalSingleton;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Clock;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    private static final Clock CLOCK = Clock.systemDefaultZone();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void lazySimpleSingletonTest() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + " : " + singleton);
            }).start();
        }
    }

    @Test
    public void lazyCheckSingletonTest() {
        long startTime = CLOCK.millis();
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                LazyCheckSingleton singleton = LazyCheckSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + " : " + singleton);
            }).start();
        }
        System.out.println("lazyCheckSingletonTest cost : " + (CLOCK.millis() - startTime));
    }

    @Test
    public void lazyDoubleCheckSingletonTest() {
        long startTime = CLOCK.millis();
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                LazyDoubleCheckSingleton singleton = LazyDoubleCheckSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + " : " + singleton);
            }).start();
        }
        System.out.println("lazyDoubleCheckSingletonTest cost : " + (CLOCK.millis() - startTime));
    }

    @Test
    public void lazyInnerSingletonTest() {
        long startTime = CLOCK.millis();
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                LazyInnerSingleton singleton = LazyInnerSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + " : " + singleton);
            }).start();
        }
        System.out.println("lazyInnerSingletonTest cost : " + (CLOCK.millis() - startTime));
    }

    @Test
    public void destroySingletonByReflect() throws NoSuchMethodException {
        long startTime = CLOCK.millis();
        Class<LazyInnerSingleton> clazz = LazyInnerSingleton.class;
        Constructor<LazyInnerSingleton> declaredConstructor = clazz.getDeclaredConstructor();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    // Forced to crack
                    declaredConstructor.setAccessible(true);
                    LazyInnerSingleton singleton = declaredConstructor.newInstance();
                    System.out.println(Thread.currentThread().getName() + " : " + singleton);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    System.out.println("exception : " + Thread.currentThread().getName());
                }

            }).start();
        }
        System.out.println("lazyInnerSingletonTest cost : " + (CLOCK.millis() - startTime));
    }

    @Test
    public void destroySingletonBySerializable() {
        long startTime = CLOCK.millis();
        SerializableHungrySingleton singleton = SerializableHungrySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + " : " + singleton);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                ObjectOutputStream oos = null;
                ObjectInputStream ois = null;
                try {
                    oos = new ObjectOutputStream(new FileOutputStream("Serializable.obj"));
                    oos.writeObject(singleton);
                    oos.flush();

                    ois = new ObjectInputStream(new FileInputStream("Serializable.obj"));
                    SerializableHungrySingleton singletons = (SerializableHungrySingleton) ois.readObject();
                    System.out.println(Thread.currentThread().getName() + " : " + singletons);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("exception : " + Thread.currentThread().getName());
                } finally {
                    if (null != oos) {
                        try {
                            oos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (null != ois) {
                        try {
                            ois.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }).start();
        }
        System.out.println("lazyInnerSingletonTest cost : " + (CLOCK.millis() - startTime));
    }

    @Test
    public void EnumSingletonTest() {
        long startTime = CLOCK.millis();
        EnumSingleton singleton = EnumSingleton.getInstance();
        singleton.setData(new Object());
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                ObjectOutputStream oos = null;
                ObjectInputStream ois = null;
                try {
                    oos = new ObjectOutputStream(new FileOutputStream("EnumSingleton.obj"));
                    oos.writeObject(singleton);
                    oos.flush();

                    ois = new ObjectInputStream(new FileInputStream("EnumSingleton.obj"));
                    EnumSingleton singletons = (EnumSingleton) ois.readObject();
                    System.out.println(Thread.currentThread().getName() + " : " + singletons.getData());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("exception : " + Thread.currentThread().getName());
                } finally {
                    if (null != oos) {
                        try {
                            oos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (null != ois) {
                        try {
                            ois.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        System.out.println("lazyInnerSingletonTest cost : " + (CLOCK.millis() - startTime));
    }

    @Test
    public void destroyEnumSingletonByReflect() throws NoSuchMethodException {
        long startTime = CLOCK.millis();
        Class<EnumSingleton> clazz = EnumSingleton.class;
        Constructor<EnumSingleton> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    // Forced to crack
                    declaredConstructor.setAccessible(true);
                    EnumSingleton singleton = declaredConstructor.newInstance("Tom", 18);
                    System.out.println(Thread.currentThread().getName() + " : " + singleton);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    System.out.println("exception : " + Thread.currentThread().getName());
                }

            }).start();
        }
        System.out.println("destroyEnumSingletonByReflect cost : " + (CLOCK.millis() - startTime));
    }

    @Test
    public void threadLocalSingletonTest() {
        long startTime = CLOCK.millis();
        for (int i = 0; i < 10; i++) {
            ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " : " + singleton);
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                // Forced to crack
                ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + " : " + singleton);
            }).start();
        }
        System.out.println("lazyInnerSingletonTest cost : " + (CLOCK.millis() - startTime));
    }

    @Test
    public void ContainerSingletonTest() {
        long startTime = CLOCK.millis();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                ContainerSingleton singleton = (ContainerSingleton) ContainerSingleton.getBean("org.example.hungry.ContainerSingleton");
                System.out.println(Thread.currentThread().getName() + " : " + singleton);
            }).start();
        }
        System.out.println("lazyCheckSingletonTest cost : " + (CLOCK.millis() - startTime));
    }
}
