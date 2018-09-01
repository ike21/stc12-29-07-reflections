package ru.innopolis.stc12.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeSet;

public class BoxClearDataInvocationHandler implements InvocationHandler {
    private Box box;

    public BoxClearDataInvocationHandler(Box box) {
        this.box = box;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method[] methods = box.getClass().getMethods();
        Set methodSet = new TreeSet<>();

        for (Method m : methods) {
            if (m.isAnnotationPresent(ClearData.class)) {
                methodSet.add(m.getName());
            }
        }
        if (methodSet.contains(method.getName())) {
            Field field = box.getClass().getDeclaredField("set");
            field.setAccessible(true);
            Set set = (Set) field.get(box);
            System.out.println(method.getName() + " before ClearData" + set);
            for (Object s : set) {
                set.remove(s);
                break;
            }
            System.out.println(method.getName() + " after ClearData" + set);
            Object result = method.invoke(box, args);
            return result;
        } else {
            return method.invoke(box, args);
        }
    }
}
