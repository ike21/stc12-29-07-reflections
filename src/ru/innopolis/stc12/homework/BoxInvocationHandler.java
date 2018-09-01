package ru.innopolis.stc12.homework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class BoxInvocationHandler implements InvocationHandler {
    private Box box;

    public BoxInvocationHandler(Box box) {
        this.box = box;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (box.getClass().getAnnotation(Logged.class) != null) {
            System.out.println("We call method " + method.getName());
            Object result = method.invoke(box, args);
            return result;
        } else {
            return method.invoke(box, args);
        }
    }
}
