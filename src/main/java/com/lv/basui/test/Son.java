package com.lv.basui.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Son extends Father {


    public Son(){
        // super();
        System.out.println("子类无参");
    }

    public Son(String s){
        super(s);
        System.out.println("子类有参");
    }

    public static void main(String[] args) {
        Father s = new Son("aaa");
        System.out.println(s.getS());

        Field[] fields = Father.class.getDeclaredFields();
        System.out.println(fields.length);
        List list = Arrays.asList(fields);
        list.forEach(f->{
            System.out.println(f);
        });
    }


}
