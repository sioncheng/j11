package com.github.sioncheng.j11.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class SimpleDynamicProxy {

    public static class MapHandler implements InvocationHandler {

        private Map map;

        public MapHandler(Map map) {
            this.map = map;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // TODO Auto-generated method stub
            System.out.println(String.format("call %s", method.getName()));
            return method.invoke(map, args);
        }
    }

    public static void main(String[] args) {
        
        MapHandler mapHandler = new MapHandler(new HashMap<String, Integer>());

        @SuppressWarnings("unchecked")
        var map = (Map<String, Integer>) Proxy.newProxyInstance(
            SimpleDynamicProxy.class.getClassLoader(),
            new Class<?>[]{Map.class}, 
            mapHandler);

        System.out.println(map.get("a"));
        map.put("a", 1);
        map.put("b", 2);
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
    }
    
}
