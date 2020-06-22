package org.example.mkproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-18 17:59:29
 */
public class MKProxy implements Serializable {

    private static final String ln = "\r\n";

    protected MKInvocationHandler h;

    private MKProxy() {

    }

    public static Object newProxyInstance(MKClassLoader classLoader,
                                          Class<?>[] interfaces,
                                          MKInvocationHandler h) throws IllegalArgumentException {
        try {
            // Dynamic build java file
            String src = generateSrc(interfaces);

            // Writing java file
            String filePath = MKProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(src);
            fileWriter.flush();
            fileWriter.close();

            // Building java file
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // Loading class file into JVM
            Class<?> proxyClass = classLoader.findClass("$Proxy0");
            Constructor<?> c = proxyClass.getConstructor(MKInvocationHandler.class);
            file.delete();
            return c.newInstance(h);
        } catch (IOException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package org.example.mkproxy;" + ln)
                .append("import org.example.jdkproxy.IPerson;" + ln)
                .append("import java.lang.reflect.*;" + ln)
                .append("public class $Proxy0 implements ")
                .append(interfaces[0].getName())
                .append("{" + ln)
                .append("MKInvocationHandler h;" + ln)
                .append("public $Proxy0(MKInvocationHandler h) {" + ln)
                .append("this.h = h;" + ln)
                .append("}" + ln);
        for (Method m : interfaces[0].getMethods()) {
            Class<?>[] params = m.getParameterTypes();
            StringBuilder paramNames = new StringBuilder();
            StringBuilder paramValues = new StringBuilder();
            StringBuilder paramClasses = new StringBuilder();

            for (int i = 0; i < params.length; i++) {
                Class<?> clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type).append(" ").append(paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName())
                        .append(".class");

                if (i > 0 && i < params.length - 1) {
                    paramNames.append(",");
                    paramValues.append(",");
                    paramClasses.append(",");
                }

            }

            sb.append("public ")
                    .append(m.getReturnType().getName())
                    .append(" ")
                    .append(m.getName())
                    .append("(")
                    .append(paramNames.toString())
                    .append(") {")
                    .append(ln)
                    .append("try{")
                    .append(ln).append("Method m = ")
                    .append(interfaces[0].getName())
                    .append(".class.getMethod (\"")
                    .append(m.getName())
                    .append("\", new Class[]{")
                    .append(paramClasses.toString())
                    .append("});")
                    .append(ln)
                    .append((hasReturnValue(m.getReturnType()) ? "return " : ""))
                    .append(getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})", m.getReturnType()))
                    .append(";" + ln)
                    .append("} catch(Error _ex) {}")
                    .append("catch (Throwable e) {" + ln)
                    .append("throw new UndeclaredThrowableException(e);" + ln)
                    .append("}")
                    .append(getReturnEmptyCode(m.getReturnType()))
                    .append("}");
        }

        sb.append("}");
        return sb.toString();
    }

    private static final Map<Class<?>, Class<?>> mappings = new HashMap<>();

    static {
        mappings.put(int.class, Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "return 0;";
        } else if (returnClass == void.class) {
            return "";
        } else {
            return "return null";
        }
    }

    private static boolean hasReturnValue(Class<?> clazz) {
        return clazz != void.class;
    }

    private static String getCaseCode(String code, Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return new String(chars);
    }

}
