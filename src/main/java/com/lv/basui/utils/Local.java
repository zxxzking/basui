package com.lv.basui.utils;


public class Local {

    public static void main(String[] args) {
       int i = 1000;
       System.out.println(System.currentTimeMillis());
       while(i < 10000){
           int a = i / 1000;
           int b = (i % 1000)/100;
           int c = ((i % 1000) % 100) / 10;
           int d = (((i % 1000) % 100) % 10);

           if(((d*1000)+(c*100)+(b*10)+a) == (4 * i)){
               System.out.println(System.currentTimeMillis());
               System.out.println(i);
               return;
           }
           i++;

       }



    }



}

