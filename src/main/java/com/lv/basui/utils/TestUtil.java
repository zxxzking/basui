package com.lv.basui.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtil {

    public static String GetUrl(String inUrl){
        StringBuilder sb = new StringBuilder();
        try {
            URL url =new URL(inUrl);
            BufferedReader reader =new BufferedReader(new InputStreamReader(url.openStream()));

            String temp="";
            while((temp=reader.readLine())!=null){
                //System.out.println(temp);
                sb.append(temp);
            }
        } catch (MalformedURLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static List<String> GetMatcher(String str, String url){
        List<String> result = new ArrayList<String>();
        Pattern p =Pattern.compile(url);//获取网页地址
        Matcher m =p.matcher(str);
        while(m.find()){
            System.out.println(m.group());
            result.add(m.group());
        }
        return result;
    }


    public static List<String> getMatcher(String s){
        Pattern p1 =Pattern.compile("<link(([\\s\\S])*?)>");
        Matcher matcher1 = p1.matcher(s);
        List<String> list = new ArrayList<>();
        while (matcher1.find()){
            // System.out.println(matcher1.start()+"  "+matcher1.end());
            System.out.println("匹配<link> 匹配到的字符"+matcher1.group());
            list.add(matcher1.group());
            s = s.replace(matcher1.group(),"");
            matcher1 = p1.matcher(s);
        }

        List<String> list1 = new ArrayList<>();


        Pattern p =Pattern.compile("href=\".*.ico\"");
        Pattern p2 =Pattern.compile("href=\"(([\\s\\S])*?).ico\"");
        for (int i=0; i<list.size();i++){
            Matcher matcher = p2.matcher(list.get(i));
            if(matcher.find()){
                // System.out.println(matcher.start()+"  "+matcher.end());
                System.out.println("匹配.ico匹配到的字符"+matcher.group(0));
                System.out.println(matcher.group(0).replace("href=","").replace("\"",""));
                list1.add(matcher.group(0).replace("href=","").replace("\"",""));
            }

        }
        return list1;
    }


    public static void main(String args[]){
        String str=GetUrl("https://www.cnblogs.com/xiaxianfei/p/5275601.html");
        List<String> ouput =getMatcher(str);

        for(String temp:ouput){
            //System.out.println(ouput.get(0));
            System.out.println(temp);
        }

    }

}
