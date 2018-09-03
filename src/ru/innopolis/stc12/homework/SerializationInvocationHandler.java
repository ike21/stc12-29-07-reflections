package ru.innopolis.stc12.homework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class SerializationInvocationHandler implements InvocationHandler {
    private SerializationXML serializationXML;

    public SerializationInvocationHandler(SerializationXML serializationXML) {
        this.serializationXML = serializationXML;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (serializationXML.getClass().getAnnotation(UseXml.class) != null) {
            Class c = LinkedList.class;
            Class[] interfaces = c.getInterfaces();
            for (Class cInterface : interfaces) {
                if (cInterface.getName().equals("java.io.Serializable")) {
                    if (method.getName().equals("write")) {
                        System.out.println("proxy write XML");
                    }
                    if (method.getName().equals("read")) {
                        System.out.println("proxy read XML");
                    }
                }
            }
            return true;
        } else {
            return method.invoke(serializationXML, args);
        }
    }
}
