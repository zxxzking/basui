package com.lv.basui.controller;

import com.lv.basui.dto.ResultBean;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class ImgCodeController extends BaseController{


    public static Map<String, String> map = new ConcurrentHashMap<>();


    @RequestMapping(value = "getImgCode/v1.0", method = RequestMethod.GET)
    // @ApiOperation(value = "获取图形验证码", notes = "/imgCode/getImgCode/v1.0")
    // @ResponseBody
    public void getImgCode(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ResultBean resultBean = new ResultBean();
        // 设置响应头 Content-type类型
        resp.setContentType("image/jpeg");
        // 以下三句是用于设置页面不缓存
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "No-cache");
        resp.setDateHeader("Expires", 0);

        OutputStream os = resp.getOutputStream();
        int width = 100, height = 40;
        // 建立指定宽、高和BufferedImage对象
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics(); // 该画笔画在image上
        Color c = g.getColor(); // 保存当前画笔的颜色，用完画笔后要回复现场
        g.fillRect(0, 0, width, height);

        char[] ch = "abcdefghjkmnpqrstuvwxyz23456789".toCharArray();
        int length = ch.length; // 随即字符串的长度
        String sRand = ""; // 保存随即产生的字符串
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            // 设置字体
            g.setFont(getFont());
            // 随即生成0-9的数字
            String rand = new Character(ch[random.nextInt(length)]).toString();
            sRand += rand;
            // 设置随机颜色
            g.setColor(new Color(random.nextInt(255), random.nextInt(255),
                    random.nextInt(255)));
            g.drawString(rand, 20 * i + 6, 25);
        }
        // 产生随即干扰点
        for (int i = 0; i < 20; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            g.drawOval(x1, y1, 2, 2);
        }
        g.setColor(c); // 将画笔的颜色再设置回去
        g.dispose();

        try {
            clean(map);
        } catch (Exception e) {
            e.printStackTrace();
        }


        String key = String.valueOf(new Date().getTime());
        map.put(key, sRand);
        logger.info("验证码的值为：" + sRand);
        logger.info("生成的key为：" + String.valueOf(new Date().getTime()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        boolean flag = ImageIO.write(image, "JPEG", out);
        byte[] b = out.toByteArray();
        String i = Base64.encodeBase64String(b);
        Map map = new HashMap();
        map.put("key", key);
        map.put("image", i);
        resultBean.setData(map);
        resp.getOutputStream().write(b);
        // return resultBean;
    }

    // 产生随即的字体
    private Font getFont() {
        Random random = new Random();
        Font font[] = new Font[5];
        font[0] = new Font("Ravie", Font.PLAIN, 24);
        font[1] = new Font("Antique Olive Compact", Font.PLAIN, 24);
        font[2] = new Font("Forte", Font.PLAIN, 24);
        font[3] = new Font("Wide Latin", Font.PLAIN, 24);
        font[4] = new Font("Gill Sans Ultra Bold", Font.PLAIN, 24);
        return font[random.nextInt(5)];
    }

    public void clean(Map map) throws Exception {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            Date date = new Date();

            // 超过5分钟 验证码失效
            long res = date.getTime() - Long.valueOf(key);
            int x = (int) (res / (60 * 1000));
            if (x >= 5) {
                map.remove(key);
            }
        }
    }
}
