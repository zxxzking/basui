package com.lv.basui.test;

public class Father {


    private String s = "father";

    public Father(){
        System.out.println("父类无参");
    }

    public Father(String s){
        System.out.println("父类有参");
    }


    public String getS() {
        return s;
    }

    public void setS(String s) {
        // this.s = s;
    }
}
