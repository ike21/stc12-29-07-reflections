package ru.innopolis.stc12.homework;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws WrongObjectArgument {

        Integer[] array = {1, 2, 3, 4, 4, 5, 6, 7};

        MathBox mathBox = new MathBox(array);

        Box mathProxy = (Box) Proxy.newProxyInstance(BoxInvocationHandler.class.getClassLoader(),
                new Class[]{Box.class}, new BoxInvocationHandler(mathBox));
        mathProxy.getSet();
        mathProxy.summator();
        mathProxy.splitter(4);

        System.out.println();

        Box mathProxyCD = (Box) Proxy.newProxyInstance(BoxClearDataInvocationHandler.class.getClassLoader(),
                new Class[]{Box.class}, new BoxClearDataInvocationHandler(mathBox));
        mathProxyCD.getSet();
        mathProxyCD.summator();
        mathProxyCD.splitter(4);

        System.out.println();

        SerializationXML mathProxySerialization = (SerializationXML) Proxy.newProxyInstance(SerializationInvocationHandler.class.getClassLoader(),
                new Class[]{SerializationXML.class}, new SerializationInvocationHandler(mathBox));
        mathProxySerialization.read();
        mathProxySerialization.write();
    }

}
