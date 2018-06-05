package com.lv.basui.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
// jdk的动态代理
public class MyInvocationHandler implements InvocationHandler {


    private Object target; //被代理者

    MyInvocationHandler() {
        super();
    }

    MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("getName".equals(method.getName())){
            System.out.println("++++++before " + method.getName() + "++++++");
            Object result = method.invoke(target, args);
            System.out.println("++++++after " + method.getName() + "++++++");
            return result;
        }else{
            Object result = method.invoke(target, args);
            return result;
        }
    }


}
